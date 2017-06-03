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

import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.utils.EstadoEstacion;

@Entity
@Table(name="Estacion")
public class Estacion extends AbstractTrackable<TrackingEstacion> {
	
	@Column
	private String nombre;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ubicacion_id")
	private Ubicacion ubicacion;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="id")
	private List<Bicicleta> bicilcetas;
	
	@Column
	private Integer capacidad;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EstadoEstacion estado;
	
	@Column
	private String direccion;
	

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
	public List<Bicicleta> getBicilcetas() {
		return bicilcetas;
	}
	public void setBicilcetas(List<Bicicleta> bicilcetas) {
		this.bicilcetas = bicilcetas;
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
	
	@Override
	public String toString(){
		return "{ id: "+this.id+", nombre: "+this.nombre+", estado: "+this.estado.getValue()+" }";
	}
	
	
	
	
}
