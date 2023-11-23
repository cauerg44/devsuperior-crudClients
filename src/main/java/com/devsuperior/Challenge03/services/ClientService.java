package com.devsuperior.challenge03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.challenge03.dto.ClientDTO;
import com.devsuperior.challenge03.entities.Client;
import com.devsuperior.challenge03.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).get();
		return new ClientDTO(client);
	}
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(Pageable pageable) {
		Page<Client> search = repository.findAll(pageable);
		return search.stream().map(x -> new ClientDTO(x)).toList();
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		dtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
	}

	private void dtoToEntity(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
	}
}
