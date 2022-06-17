package com.example.democrud.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long num_factura;

	@JoinColumn(name = "id_cliente", referencedColumnName = "cliente")
	private long id_cliente;
	
	@Column(name = "fecha", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	@DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss")
	private Timestamp fecha;

	public Long getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(Long num_factura) {
		this.num_factura = num_factura;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	
	
	
	
}
