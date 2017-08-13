package com.laplataenbici.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;

@Entity
@Table(name="Bicicleta")
public class Bicicleta extends AbstractEntity{
	
	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;
	
	@Column(name="fecha_devolucion")
	private Timestamp fechaDevolucion;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoBicicleta estado;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="usuario_id")
	@JsonManagedReference
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="estacion_id")
	@JsonManagedReference
	private Estacion estacion;

	@Column
	private String detalle;

	public Bicicleta() {
		super();
	}
	
	public Bicicleta(Long id) {
		super(id);
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Timestamp fechaIngreso) {
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
	public Timestamp getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

	public String getDetalle() {
		return detalle;
	}
	
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
	@Override
	public String toString(){
		return "{ id: "+this.id+", estado: "+this.estado.getValue()+" }";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Bicicleta && super.equals(obj);
	}

}
