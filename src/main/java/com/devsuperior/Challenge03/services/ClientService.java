package com.devsuperior.challenge03.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.challenge03.dto.ClientDTO;
import com.devsuperior.challenge03.entities.Client;
import com.devsuperior.challenge03.repositories.ClientRepository;
import com.devsuperior.challenge03.services.exceptions.DataBaseException;
import com.devsuperior.challenge03.services.exceptions.SearchNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Client client = repository.findById(id).orElseThrow(
				() -> new SearchNotFoundException("Resource not found!"));
		return new ClientDTO(client);
	}
	
	@Transactional(readOnly = true)
	public Page<ClientDTO> findAll(Pageable pageable) {
		Page<Client> search = repository.findAll(pageable);
		return search.map(x -> new ClientDTO(x));
	}
	
	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		Client client = new Client();
		dtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
	}

	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
		Client client = repository.getReferenceById(id);
		dtoToEntity(dto, client);
		client = repository.save(client);
		return new ClientDTO(client);
		}
		catch (EntityNotFoundException e) {
			throw new SearchNotFoundException("Resource not found!");
		}
	}
		
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new SearchNotFoundException("Resource not found");
		}
		try {
		repository.deleteById(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Integrity violation reference fail");
		}
	}
	
	private void dtoToEntity(ClientDTO dto, Client client) {
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
	}
}
