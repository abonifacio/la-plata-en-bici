package com.laplataenbici.model.domain.tracking;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.AbstractTrackable;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.utils.DateUtils;

@MappedSuperclass
public abstract class AbstractTracking<T extends AbstractTrackable> extends AbstractEntity{
	
	@Column
	private Timestamp fecha;
	
	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario modificadoPor;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<TrackingItem> items;
	
	@Enumerated(EnumType.STRING)
	private OperacionTracking operacion;
	
	@OneToOne
	@JoinColumn(name="entity_id")
	private T entity;
	
	public AbstractTracking(){
		this.fecha = DateUtils.now();
	}

	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	public Usuario getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(Usuario modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public List<TrackingItem> getItems() {
		return items;
	}

	public void setItems(List<TrackingItem> items) {
		this.items = items;
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
		return "{ id: "+this.id+", operacion: "+this.operacion.toString()+" }";
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof AbstractTracking && super.equals(obj);
	}
	
	
}
