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

import com.example.democrud.model.Cliente;
import com.example.democrud.service.api.ClienteServiceAPI;

@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ClienteRestController {

	@Autowired
	private ClienteServiceAPI clienteServiceAPI;

	@GetMapping(value = "/allcliente")
	public List<Cliente> getAll() {
		return clienteServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id_cliente}")
	public Cliente find(@PathVariable Long id_cliente) {
		return clienteServiceAPI.get(id_cliente);
	}

	@PostMapping(value = "/saveclientes")
	public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente) {
		Cliente obj = clienteServiceAPI.save(cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
	}

	@GetMapping(value = "/delete/{id_cliente}")
	public ResponseEntity<Cliente> delete(@PathVariable Long id_cliente) {
		Cliente cliente = clienteServiceAPI.get(id_cliente);
		if (cliente != null) {
			clienteServiceAPI.delete(id_cliente);
		} else {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

}
