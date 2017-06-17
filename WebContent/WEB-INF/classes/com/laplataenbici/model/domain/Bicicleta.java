package com.laplataenbici.model.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;

@Entity
@Table(name="Bicicleta")
public class Bicicleta extends AbstractTrackable<TrackingBicicleta>{
	
	@Column(name="fecha_ingreso")
	private Date fechaIngreso;
	
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoBicicleta estado;
	
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="usuario_id")
	@JsonBackReference
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinColumn(name="estacion_id")
	private Estacion estacion;
	

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
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
	@Override
	public String toString(){
		return "{ id: "+this.id+", estado: "+this.estado.getValue()+" }";
	}
	
	
	
	
	
	
	
	
}
