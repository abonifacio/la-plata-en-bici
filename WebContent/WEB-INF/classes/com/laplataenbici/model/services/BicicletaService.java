package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.DateUtils;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;
import com.laplataenbici.model.services.tracking.AbstractTrackableService;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingBicicletaService;
import com.laplataenbici.security.SecurityUtils;

public class BicicletaService extends AbstractTrackableService<Bicicleta,TrackingBicicleta>{

	
	private BicicletaRepository repo = new BicicletaRepositoryImpl();
	
	private TrackingBicicletaService trackingService = new TrackingBicicletaService();
	
	
	@Override
	public Bicicleta update(Bicicleta entity) throws LPBException {
		return super.update(entity);
	}
		
	@Override
	protected EntityRepository<Bicicleta> getRepo() {
		return repo;
	}

	@Override
	public TrackingBicicleta createTracking() {
		return new TrackingBicicleta();
	}

	@Override
	public AbstractTrackingService<TrackingBicicleta> getTrackingService() {
		return trackingService;
	}
	
	public Bicicleta devolver(Bicicleta entity) throws LPBException {
		Bicicleta b = this.get(entity.getId());
		if(!SecurityUtils.getCurrentUser().equals(b.getUsuario())){
			throw new BusinessException("El usuario no tiene esta bicicleta alquilada");
		}
		Estacion est = entity.getEstacion();
		if(est.getCapacidad()>=est.getBicicletas().size()){
			throw new BusinessException("La estación no tiene cupo para devolver esta bicicleta");
		}
		entity.setFechaDevolucion(null);
		entity.setUsuario(null);
		entity.setFechaIngreso(DateUtils.now());
		return super.update(entity);
	}

	public Bicicleta retirar(Bicicleta entity) throws LPBException {
		Bicicleta b = this.get(entity.getId());
		if(b.getUsuario()!=null){
			throw new BusinessException("Esta bicicleta ya esta alquilada");
		}
		if(!EstadoBicicleta.APTA.equals(b.getEstado())){
			throw new BusinessException("La bicicleta no se puede retirar porque está "+b.getEstado().getValue());
		}
		entity.setFechaDevolucion(DateUtils.endOfDay());
		entity.setFechaIngreso(DateUtils.now());
		entity.setEstacion(null);
		entity.setUsuario(SecurityUtils.getCurrentUser());
		return super.update(entity);
	}

}
