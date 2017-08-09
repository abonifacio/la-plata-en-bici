package com.laplataenbici.model.domain.tracking;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.AbstractTrackable;
import com.laplataenbici.model.domain.Usuario;

@MappedSuperclass
public abstract class AbstractTracking<T extends AbstractTrackable> extends AbstractEntity{
	
	@Column
	private Date fecha;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="usuario_id")
	private Usuario modificadorPor;
	
	private String mensaje;
	
	@Enumerated(EnumType.STRING)
	private OperacionTracking operacion;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="entity_id")
	private T entity;
	
	public AbstractTracking(){
		this.fecha = new Date();
	}

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
	public OperacionTracking getOperacion() {
		return operacion;
	}
	public void setOperacion(OperacionTracking operacion) {
		this.operacion = operacion;
	}
	public T getEntity() {
		return entity;
	}
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	@Override
	public String toString(){
		return "{ id: "+this.id+", mensaje: "+this.mensaje+", operacion: "+this.operacion.toString()+" }";
	}
	
	
	
	
}
