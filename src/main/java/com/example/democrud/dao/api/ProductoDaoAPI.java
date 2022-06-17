package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;


import com.example.democrud.model.Producto;

public interface ProductoDaoAPI extends CrudRepository<Producto, Long> {

}
