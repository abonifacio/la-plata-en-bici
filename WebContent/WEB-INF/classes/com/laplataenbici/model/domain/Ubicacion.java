package com.laplataenbici.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ubicacion")
public class Ubicacion extends AbstractEntity {
	
	@Column
	private Double longitud;
	
	@Column
	private Double latitud;
	
	
	public Ubicacion(){
		
	}
	
	public Ubicacion(Double lon, Double lat){
		this.longitud = lon;
		this.latitud = lat;
	}
	
	
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
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Ubicacion && super.equals(obj);
	}
	
	
}
