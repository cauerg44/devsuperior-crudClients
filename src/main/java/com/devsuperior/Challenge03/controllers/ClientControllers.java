package com.devsuperior.challenge03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.challenge03.dto.ClientDTO;
import com.devsuperior.challenge03.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientControllers {

	@Autowired
	private ClientService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
		ClientDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
}