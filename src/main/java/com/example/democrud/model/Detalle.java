package com.example.democrud.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;



@Entity
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long num_detalle;
	
	@JoinColumn(name = "id_factura", referencedColumnName = "factura")
	private long id_factura;
	
	@JoinColumn(name = "id_producto", referencedColumnName = "producto")
	private long id_producto;
	@Column
	private int cantidad;
	@Column
	private double precio;
	public Long getNum_detalle() {
		return num_detalle;
	}
	public void setNum_detalle(Long num_detalle) {
		this.num_detalle = num_detalle;
	}
	public long getId_factura() {
		return id_factura;
	}
	public void setId_factura(long id_factura) {
		this.id_factura = id_factura;
	}
	public long getId_producto() {
		return id_producto;
	}
	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
		
	
}
