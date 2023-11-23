package com.devsuperior.challenge03.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.challenge03.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
