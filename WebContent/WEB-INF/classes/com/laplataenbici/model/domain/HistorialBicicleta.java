package com.laplataenbici.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.domain.utils.TipoHistorial;

@Entity
@Table(name = "HistorialBicicleta")
public class HistorialBicicleta extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="bicicleta_id")
	private Bicicleta bicicleta;
	
	@Column(name="fecha_ingreso")
	private Timestamp fechaIngreso;
	
	@Column(name="fecha_devolucion")
	private Timestamp fechaDevolucion;
	
	@Column
	private EstadoBicicleta estado;
	
	@Column
	private TipoHistorial tipo;
	
	@OneToOne
	@JoinColumn(name="usuario_id",nullable = true)
	private Usuario alquiladaPor;
	
	@Column
	private String detalle;

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Timestamp getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Timestamp fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Timestamp getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Timestamp fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public EstadoBicicleta getEstado() {
		return estado;
	}

	public void setEstado(EstadoBicicleta estado) {
		this.estado = estado;
	}

	public Usuario getAlquiladaPor() {
		return alquiladaPor;
	}

	public void setAlquiladaPor(Usuario alquiladaPor) {
		this.alquiladaPor = alquiladaPor;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public TipoHistorial getTipo() {
		return tipo;
	}

	public void setTipo(TipoHistorial tipo) {
		this.tipo = tipo;
	}
	
	

}
