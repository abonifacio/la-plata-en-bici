package com.laplataenbici.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;

@Entity
@Table
public class Bicicleta extends AbstractTrackable<TrackingBicicleta>{
	
	@Column
	private Date fechaIngreso;
	
	@Column
	private Date fechaDevolucion;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoBicicleta estado;
	
//	@OneToOne
//	private Usuario usuario;
//	
//	@ManyToOne
//	private Estacion estacion;
	

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
//	public Usuario getUsuario() {
//		return usuario;
//	}
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
//	public Estacion getEstacion() {
//		return estacion;
//	}
//	public void setEstacion(Estacion estacion) {
//		this.estacion = estacion;
//	}
	
	
	
	
	
	
	
	
}
