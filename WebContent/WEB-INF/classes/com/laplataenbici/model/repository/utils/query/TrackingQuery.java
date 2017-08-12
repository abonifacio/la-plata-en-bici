package com.laplataenbici.model.repository.utils.query;

import java.sql.Timestamp;

import javax.ws.rs.core.MultivaluedMap;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.utils.DateUtils;

public class TrackingQuery<T extends AbstractEntity> extends BaseQuery{
	
	private OperacionTracking operacion;
	private Timestamp desde;
	private Timestamp hasta;
	private Usuario user;
	private T entidad;
	
	public TrackingQuery(MultivaluedMap<String,String> params){
		super(params);
	}
	
	public TrackingQuery(OperacionTracking operacion, Long desde, Long hasta, Long user, T entidad) {
		this.operacion = operacion;
		this.desde = desde==null? null : DateUtils.now(desde);
		this.hasta = hasta==null? null : DateUtils.now(hasta);
		this.user = user==null ? null : new Usuario(user);
		this.entidad = entidad;
	}

	public OperacionTracking getOperacion() {
		return operacion;
	}

	public void setOperacion(OperacionTracking operacion) {
		this.operacion = operacion;
	}

	public Timestamp getDesde() {
		return desde;
	}

	public void setDesde(Timestamp desde) {
		this.desde = desde;
	}

	public Timestamp getHasta() {
		return hasta;
	}

	public void setHasta(Timestamp hasta) {
		this.hasta = hasta;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public T getEntidad() {
		return entidad;
	}

	public void setEntidad(T entidad) {
		this.entidad = entidad;
	}
	
	
	
	

}
