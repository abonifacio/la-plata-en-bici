package com.laplataenbici.model.domain;

import java.util.Date;

import com.laplataenbici.model.domain.utils.EstadoBicicleta;

public class Bicicleta{
	
	private Long id;
	private Date fechaIngreso;
	private Date fechaDevolucion;
	private EstadoBicicleta estado;
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public EstadoBicicleta getEstado() {
		return estado;
	}
	public void setEstado(EstadoBicicleta estado) {
		this.estado = estado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	
	
	
	
	
	
	
}
