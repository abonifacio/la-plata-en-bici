package com.laplataenbici.model.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.laplataenbici.model.domain.utils.EstadoBicicleta;

public class HistorialBicicleta extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="bicicleta_id")
	private Bicicleta bicicleta;
	
	@Column
	private Timestamp fecha;
	
	@Column
	private EstadoBicicleta estado;
	
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

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
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
	
	

}
