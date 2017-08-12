package com.laplataenbici.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Localidad")
public class Localidad extends AbstractEntity {
	
	@Column
	private String nombre;
	
	@Column(name="codigo_postal")
	private Integer codigoPostal;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Override
	public String toString(){
		return "{ id: "+this.id+", nombre: "+this.nombre+", codigo postal: "+this.codigoPostal+" }";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Localidad && super.equals(obj);
	}
	
}
