package com.laplataenbici.model.services.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.AbstractTrackable;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.services.AbstractEntityService;
import com.laplataenbici.security.SecurityUtils;



public abstract class AbstractTrackableService<T extends AbstractTrackable,U extends AbstractTracking<T>> extends AbstractEntityService<T> {

	@Override
	public T create(T entity) throws LPBException {
		this.track(entity,OperacionTracking.ALTA);
		return super.create(entity);
	}
	
	@Override
	public T update(T entity) throws LPBException {
		return this.update(entity,"");
	}
	
	public T update(T entity, String mensaje) throws LPBException{
		this.track(entity,OperacionTracking.MODIFICACION);
		return super.update(entity);
	}
	
	@Override
	public void delete(Long id) throws LPBException {
		this.track(null,OperacionTracking.BAJA);
		super.delete(id);
	}
	
	private void track(T entity,OperacionTracking operacion,String mensaje) throws LPBException{
		U tracking = this.createTracking();		
		tracking.setEntity(entity);
		tracking.setFecha(new Date());
		tracking.setModificadorPor(SecurityUtils.getCurrentUser());
		tracking.setOperacion(operacion);
		this.getTrackingService().create(tracking);
	}
	
	private void track(T entity,OperacionTracking operacion) throws LPBException{
		this.track(entity, operacion,"");
	}
	
	public abstract U createTracking();
	
	public abstract AbstractTrackingService<U> getTrackingService();
}
