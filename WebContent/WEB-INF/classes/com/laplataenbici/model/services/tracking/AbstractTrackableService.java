package com.laplataenbici.model.services.tracking;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laplataenbici.model.domain.AbstractTrackable;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.tracking.TrackingItem;
import com.laplataenbici.model.domain.utils.DateUtils;
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
		this.track(entity,OperacionTracking.MODIFICACION,this.diff(entity));
		return super.update(entity);
	}
	
	@Override
	public void delete(Long id) throws LPBException {
		this.track(null,OperacionTracking.BAJA);
		super.delete(id);
	}
	
	private void track(T entity,OperacionTracking operacion,List<TrackingItem> items) throws LPBException{
		U tracking = this.createTracking();		
		tracking.setEntity(entity);
		tracking.setFecha(DateUtils.now());
		tracking.setModificadoPor(SecurityUtils.getCurrentUser());
		tracking.setOperacion(operacion);
		tracking.setItems(items);
		this.getTrackingService().create(tracking);
	}
	
	private void track(T entity,OperacionTracking operacion) throws LPBException{
		this.track(entity, operacion,null);
	}
	
	public abstract U createTracking();
	
	public abstract AbstractTrackingService<U> getTrackingService();
	
	private List<TrackingItem> diff(T entity) throws LPBException{
		T old = this.get(entity.getId());
		Map<String,Object> ppts = new HashMap<>();
		List<TrackingItem> items = new ArrayList<>();
		for(Field f : entity.getClass().getDeclaredFields()){
			try{
				f.setAccessible(true);
				ppts.put(f.getName(), f.get(entity));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		for(String ppty: ppts.keySet()){
			try {
				Field f = old.getClass().getDeclaredField(ppty);
				f.setAccessible(true);
				Object viejo = f.get(old);
				Object nuevo = ppts.get(ppty);
				if(!viejo.equals(nuevo)){
					TrackingItem item = new TrackingItem();
					item.setAtributo(ppty);
					item.setValor(String.valueOf(nuevo));
					item.setAnterior(String.valueOf(viejo));
					items.add(item);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
