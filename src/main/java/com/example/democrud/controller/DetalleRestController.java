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

import com.example.democrud.model.Detalle;
import com.example.democrud.service.api.DetalleServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class DetalleRestController {

	@Autowired
	private DetalleServiceAPI detalleServiceAPI;

	@GetMapping(value = "/alldetalle")
	public List<Detalle> getAll() {
		return detalleServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{num_detalle}")
	public Detalle find(@PathVariable Long id_detalle) {
		return detalleServiceAPI.get(id_detalle);
	}

	@PostMapping(value = "/savedetalle")
	public ResponseEntity<Detalle> save(@RequestBody @Valid Detalle detalle) {
		Detalle obj = detalleServiceAPI.save(detalle);
		return new ResponseEntity<Detalle>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{num_detalle}")
	public ResponseEntity<Detalle> delete(@PathVariable Long id_detalle) {
		Detalle detalle = detalleServiceAPI.get(id_detalle);
		if (detalle != null) {
			detalleServiceAPI.delete(id_detalle);
		} else {
			return new ResponseEntity<Detalle>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Detalle>(detalle, HttpStatus.OK);
	}

}
