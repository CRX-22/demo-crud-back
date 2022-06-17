package com.example.democrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democrud.model.Producto;
import com.example.democrud.service.api.ProductoServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ProductoRestController {

	@Autowired
	private ProductoServiceAPI productoServiceAPI;

	@GetMapping(value = "/allproducto")
	public List<Producto> getAll() {
		return productoServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id_producto}")
	public Producto find(@PathVariable Long id_producto) {
		return productoServiceAPI.get(id_producto);
	}

	@PostMapping(value = "/saveproducto")
	public ResponseEntity<Producto> save(@RequestBody @Valid Producto producto) {
		Producto obj = productoServiceAPI.save(producto);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id_producto}")
	public ResponseEntity<Producto> delete(@PathVariable Long id_producto) {
		Producto producto = productoServiceAPI.get(id_producto);
		if (producto != null) {
			productoServiceAPI.delete(id_producto);
		} else {
			return new ResponseEntity<Producto>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Producto>(producto, HttpStatus.OK);
	}

}
