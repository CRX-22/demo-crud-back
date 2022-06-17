package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.FacturaDaoAPI;
import com.example.democrud.model.Factura;
import com.example.democrud.service.api.FacturaServiceAPI;

@Service
public class FacturaServiceImpl extends GenericServiceImpl<Factura, Long> implements FacturaServiceAPI {

	@Autowired
	private FacturaDaoAPI facturaDaoAPI;
	
	@Override
	public CrudRepository<Factura, Long> getDao() {
		return facturaDaoAPI;
	}

}
