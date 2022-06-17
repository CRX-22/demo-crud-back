package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.ClienteDaoAPI;
import com.example.democrud.model.Cliente;
import com.example.democrud.service.api.ClienteServiceAPI;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteServiceAPI {

	@Autowired
	private ClienteDaoAPI clienteDaoAPI;
	
	@Override
	public CrudRepository<Cliente, Long> getDao() {
		return clienteDaoAPI;
	}

}
