package com.laplataenbici.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.utils.EstadoEstacion;

@Entity
@Table
public class Estacion extends AbstractTrackable<TrackingEstacion> {
	
	@Column
	private String nombre;
	
	@OneToOne
	private Ubicacion ubicacion;
	
//	@OneToMany(fetch=FetchType.LAZY,mappedBy="estacion")
//	private List<Bicicleta> bicilcetas;
	
	@Column
	private Integer capacidad;
	
	@Column
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
//	public List<Bicicleta> getBicilcetas() {
//		return bicilcetas;
//	}
//	public void setBicilcetas(List<Bicicleta> bicilcetas) {
//		this.bicilcetas = bicilcetas;
//	}
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
	
	
	
	
}
