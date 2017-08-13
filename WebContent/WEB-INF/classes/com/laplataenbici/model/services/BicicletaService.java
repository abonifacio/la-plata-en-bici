package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.DateUtils;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;

public class BicicletaService extends AbstractEntityService<Bicicleta>{

	
	private BicicletaRepository repo = new BicicletaRepositoryImpl();
	
	private HistorialBicicletaService historial = new HistorialBicicletaService();
	
	
	@Override
	public Bicicleta update(Bicicleta entity) throws LPBException {
		return super.update(entity);
	}
		
	@Override
	protected EntityRepository<Bicicleta> getRepo() {
		return repo;
	}
	
	public Bicicleta devolver(Bicicleta entity,Usuario cUser) throws LPBException {
		Bicicleta b = this.get(entity.getId());
		if(!cUser.equals(b.getUsuario())){
			throw new BusinessException("El usuario no tiene esta bicicleta alquilada");
		}
		Estacion est = entity.getEstacion();
		if(est.getCapacidad()>=est.getBicicletas().size()){
			throw new BusinessException("La estación no tiene cupo para devolver esta bicicleta");
		}
		entity.setFechaDevolucion(null);
		entity.setUsuario(null);
		entity.setFechaIngreso(DateUtils.now());
		
		HistorialBicicleta h = new HistorialBicicleta();
		h.setBicicleta(entity);
		h.setEstado(entity.getEstado());
		h.setDetalle(entity.getDetalle());
		h.setFecha(DateUtils.now());
		historial.create(h);
		return super.update(entity);
	}

	public Bicicleta retirar(Bicicleta entity,Usuario cUser) throws LPBException {
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
		entity.setUsuario(cUser);
		
		HistorialBicicleta h = new HistorialBicicleta();
		h.setBicicleta(entity);
		h.setEstado(entity.getEstado());
		h.setDetalle(entity.getDetalle());
		h.setFecha(DateUtils.now());
		h.setAlquiladaPor(cUser);
		historial.create(h);
		
		return super.update(entity);
	}
	
	public Long countAlquiladas() throws DBException{
		return repo.countAlquiladas();
	}

}
