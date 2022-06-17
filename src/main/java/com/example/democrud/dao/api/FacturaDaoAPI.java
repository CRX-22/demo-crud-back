package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Factura;

public interface FacturaDaoAPI extends CrudRepository<Factura, Long> {

}
