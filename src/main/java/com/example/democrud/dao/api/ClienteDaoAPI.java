package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Cliente;

public interface ClienteDaoAPI extends CrudRepository<Cliente, Long> {

}
