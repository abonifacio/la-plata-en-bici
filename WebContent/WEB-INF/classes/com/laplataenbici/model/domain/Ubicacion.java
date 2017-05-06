package com.laplataenbici.model.domain;

public class Ubicacion extends AbstractEntity {
	private Double longitud;
	private Double latitud;
	private Estacion estacion;
	
	
	public Double getLongitud() {
		return longitud;
	}
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
	
	
	
}
