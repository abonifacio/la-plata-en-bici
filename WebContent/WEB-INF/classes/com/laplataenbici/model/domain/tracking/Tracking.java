package com.laplataenbici.model.domain.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.Usuario;

public abstract class Tracking<T,U> extends AbstractEntity{
	
	private Date fecha;
	private Usuario modificadorPor;
	private String mensaje;
	private T operacion;
	private U entity;

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getModificadorPor() {
		return modificadorPor;
	}
	public void setModificadorPor(Usuario modificadorPor) {
		this.modificadorPor = modificadorPor;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getOperacion() {
		return operacion;
	}
	public void setOperacion(T operacion) {
		this.operacion = operacion;
	}
	public U getEntity() {
		return entity;
	}
	public void setEntity(U entity) {
		this.entity = entity;
	}
	
	
	
	
}
