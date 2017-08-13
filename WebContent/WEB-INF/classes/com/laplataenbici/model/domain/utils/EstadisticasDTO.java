package com.laplataenbici.model.domain.utils;

import java.util.HashMap;
import java.util.Map;

public class EstadisticasDTO {
	
	
	Map<EstadoUsuario,Long> usuariosPorEstado = new HashMap<>();
	Map<EstadoEstacion,Long> estacionesPorEstado = new HashMap<>();
	Map<EstadoBicicleta,Long> bicicletasPorEstado = new HashMap<>();
	
	Long bicicletas = 0L;
	Long estaciones = 0L;
	Long usuarios = 0L;
	Long bicicletasAlquiladas = 0L;
	
	public Map<EstadoUsuario, Long> getUsuariosPorEstado() {
		return usuariosPorEstado;
	}
	public Map<EstadoEstacion, Long> getEstacionesPorEstado() {
		return estacionesPorEstado;
	}
	public Map<EstadoBicicleta, Long> getBicicletasPorEstado() {
		return bicicletasPorEstado;
	}
	public Long getBicicletasAlquiladas() {
		return bicicletasAlquiladas;
	}
	public void setBicicletasAlquiladas(Long bicicletasAlquiladas) {
		this.bicicletasAlquiladas = bicicletasAlquiladas;
	}
	
	public void setCantidadEstado(EstadoBicicleta estado,Long cantidad){
		this.bicicletasPorEstado.put(estado, cantidad);
	}
	public void setCantidadEstado(EstadoUsuario estado,Long cantidad){
		this.usuariosPorEstado.put(estado, cantidad);
	}
	public void setCantidadEstado(EstadoEstacion estado,Long cantidad){
		this.estacionesPorEstado.put(estado, cantidad);
	}
	public Long getBicicletas() {
		return bicicletas;
	}
	public void setBicicletas(Long bicicletas) {
		this.bicicletas = bicicletas;
	}
	public Long getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(Long estaciones) {
		this.estaciones = estaciones;
	}
	public Long getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Long usuarios) {
		this.usuarios = usuarios;
	}
	

}
