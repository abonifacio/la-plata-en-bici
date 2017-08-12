package com.laplataenbici.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.laplataenbici.model.domain.utils.EstadoEstacion;

@Entity
@Table(name="Estacion")
public class Estacion extends AbstractTrackable {
	
	@Column
	private String nombre;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ubicacion_id")
	private Ubicacion ubicacion;
	
	@OneToMany(mappedBy="id",fetch=FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JsonBackReference
	private List<Bicicleta> bicicletas;
	
	@Column
	private Integer capacidad;
	
	@Transient
	private Integer ocupacion;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoEstacion estado;
	
	@Column
	private String direccion;

	

	public Estacion() {
		super();
	}
	public Estacion(Long id) {
		super(id);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}
	public void setBicicletas(List<Bicicleta> bicilcetas) {
		this.bicicletas = bicilcetas;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public EstadoEstacion getEstado() {
		return estado;
	}
	public void setEstado(EstadoEstacion estado) {
		this.estado = estado;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Integer getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(Integer ocupacion) {
		this.ocupacion = ocupacion;
	}
	@Override
	public String toString(){
		return "{ id: "+this.id+", nombre: "+this.nombre+", estado: "+this.estado.getValue()+" }";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Estacion && super.equals(obj);
	}
	
	
}
