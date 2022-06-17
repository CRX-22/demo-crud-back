package com.example.democrud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.DetalleDaoAPI;
import com.example.democrud.model.Detalle;
import com.example.democrud.service.api.DetalleServiceAPI;

@Service
public class DetalleServiceImpl extends GenericServiceImpl<Detalle, Long> implements DetalleServiceAPI {

	@Autowired
	private DetalleDaoAPI detalleDaoAPI;
	
	@Override
	public CrudRepository<Detalle, Long> getDao() {
		return detalleDaoAPI;
	}

}
