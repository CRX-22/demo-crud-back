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

import com.example.democrud.model.Factura;
import com.example.democrud.service.api.FacturaServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class FacturaRestController {

	@Autowired
	private FacturaServiceAPI facturaServiceAPI;

	@GetMapping(value = "/allfactura")
	public List<Factura> getAll() {
		return facturaServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{num_factura}")
	public Factura find(@PathVariable Long num_factura) {
		return facturaServiceAPI.get(num_factura);
	}

	@PostMapping(value = "/savefactura")
	public ResponseEntity<Factura> save(@RequestBody @Valid Factura factura) {
		Factura obj = facturaServiceAPI.save(factura);
		return new ResponseEntity<Factura>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{num_factura}")
	public ResponseEntity<Factura> delete(@PathVariable Long num_factura) {
		Factura factura = facturaServiceAPI.get(num_factura);
		if (factura != null) {
			facturaServiceAPI.delete(num_factura);
		} else {
			return new ResponseEntity<Factura>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Factura>(factura, HttpStatus.OK);
	}

}
