package com.laplataenbici.model.domain;

import java.util.List;

import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.utils.EstadoEstacion;

public class Estacion extends AbstractTrackable<TrackingEstacion> {
	
	private String nombre;
	private Ubicacion ubicacion;
	private List<Bicicleta> bicilcetas;
	private Integer capacidad;
	private EstadoEstacion estado;
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
	
	
	
	
}
