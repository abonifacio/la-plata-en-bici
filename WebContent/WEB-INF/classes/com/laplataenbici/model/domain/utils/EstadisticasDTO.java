package com.laplataenbici.model.domain.utils;

import java.util.ArrayList;
import java.util.List;

public class EstadisticasDTO {
	
	
	List<Cantidad> usuariosPorEstado = new ArrayList<>();
	List<Cantidad> estacionesPorEstado = new ArrayList<>();
	List<Cantidad> bicicletasPorEstado = new ArrayList<>();
	
	Long bicicletas = 0L;
	Long estaciones = 0L;
	Long usuarios = 0L;
	Long bicicletasAlquiladas = 0L;
	
	public Long getBicicletasAlquiladas() {
		return bicicletasAlquiladas;
	}
	public void setBicicletasAlquiladas(Long bicicletasAlquiladas) {
		this.bicicletasAlquiladas = bicicletasAlquiladas;
	}
	
	public void setCantidadEstado(EstadoBicicleta estado,Long cantidad){
		this.bicicletasPorEstado.add(new Cantidad(estado.name(),cantidad));
	}
	public void setCantidadEstado(EstadoUsuario estado,Long cantidad){
		this.usuariosPorEstado.add(new Cantidad(estado.name(),cantidad));
	}
	public void setCantidadEstado(EstadoEstacion estado,Long cantidad){
		this.estacionesPorEstado.add(new Cantidad(estado.name(),cantidad));
	}
	
	public List<Cantidad> getUsuariosPorEstado() {
		return usuariosPorEstado;
	}
	public List<Cantidad> getEstacionesPorEstado() {
		return estacionesPorEstado;
	}
	public List<Cantidad> getBicicletasPorEstado() {
		return bicicletasPorEstado;
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
	
	public static class Cantidad{
		private String label;
		private Long value;
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public Long getValue() {
			return value;
		}
		public void setValue(Long value) {
			this.value = value;
		}
		
		public Cantidad(String label,Long value) {
			this.label = label;
			this.value = value;
		}
		
		
	}

}
