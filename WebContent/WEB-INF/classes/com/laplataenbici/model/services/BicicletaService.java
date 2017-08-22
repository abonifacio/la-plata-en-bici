package com.laplataenbici.model.services;

import java.util.List;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.DateUtils;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.TipoHistorial;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.impl.BicicletaRepositoryImpl;

public class BicicletaService extends AbstractEntityService<Bicicleta>{

	
	private BicicletaRepository repo = new BicicletaRepositoryImpl();
	
	private HistorialBicicletaService historial = new HistorialBicicletaService();
	
	private EstacionService estaciones = new EstacionService();
	
	@Override
	protected EntityRepository<Bicicleta> getRepo() {
		return repo;
	}
	
	@Override
	public Bicicleta create(Bicicleta entity) throws LPBException {
		Estacion est = estaciones.get(entity.getEstacion().getId());
		if(est.getOcupacion()>=est.getCapacidad()){
			throw new BusinessException("La estación no tiene cupo para agregar esta bicicleta");
		}
		entity.setFechaIngreso(DateUtils.now());
		entity.setUsuario(null);
		entity.setFechaDevolucion(null);
		entity = super.create(entity);
		
		HistorialBicicleta h = this.getHistorial(entity);
		h.setTipo(TipoHistorial.CREACION);
		historial.create(h);
		
		return entity;
	}
	
	@Override
	public Bicicleta update(Bicicleta entity) throws LPBException {
		Bicicleta b = this.get(entity.getId());
		if(b.getUsuario()!=null){
			throw new BusinessException("No se puede editar una bicicleta que está alquilada");
		}
		if(!b.getEstado().equals(entity.getEstado())){
			b.setEstado(entity.getEstado());
			HistorialBicicleta h = this.getHistorial(b);
			h.setTipo(TipoHistorial.CAMBIO);
			historial.create(h);
		}
		return super.update(entity);
	}
	
	public Bicicleta devolver(Bicicleta entity,Usuario cUser) throws LPBException {
		Bicicleta b = this.get(entity.getId());
		if(!cUser.equals(b.getUsuario())){
			throw new BusinessException("El usuario no tiene esta bicicleta alquilada");
		}
		Estacion est = estaciones.get(entity.getEstacion().getId());
		if(est.getOcupacion()>=est.getCapacidad()){
			throw new BusinessException("La estación no tiene cupo para devolver esta bicicleta");
		}
		
		HistorialBicicleta h = this.getHistorial(b);
		h.setFechaIngreso(DateUtils.now());
		h.setAlquiladaPor(null);
		h.setTipo(TipoHistorial.DEVOLUCION);
		historial.create(h);
		
		b.setFechaDevolucion(null);
		b.setUsuario(null);
		b.setFechaIngreso(DateUtils.now());
		
		return super.update(b);
	}

	public Bicicleta retirar(Estacion estacion,Usuario cUser) throws LPBException {
		Bicicleta b = repo.getRandomBicicleta(estacion);
		if(b==null){
			throw new BusinessException("No hay bicicletas disponibles en "+estacion.getNombre());
		}
		if(!cUser.getEstado().equals(EstadoUsuario.HABILITADO)){
			throw new BusinessException("El usuario se encuentra "+cUser.getEstado().getValue());
		}
		b.setFechaDevolucion(DateUtils.endOfDay());
		b.setFechaIngreso(DateUtils.now());
		b.setEstacion(null);
		b.setUsuario(cUser);
		
		HistorialBicicleta h = this.getHistorial(b);
		h.setAlquiladaPor(cUser);
		h.setTipo(TipoHistorial.RETIRO);
		historial.create(h);
		
		return super.update(b);
	}
	
	public Long countAlquiladas() throws DBException{
		return repo.countAlquiladas();
	}
	
	public List<Bicicleta> getAlquiladas(Usuario u) throws LPBException{
		return repo.getByUser(u);
	}
	
	private HistorialBicicleta getHistorial(Bicicleta b){
		HistorialBicicleta h = new HistorialBicicleta();
		h.setBicicleta(b);
		h.setEstado(b.getEstado());
		h.setDetalle(b.getDetalle());
		h.setFechaIngreso(b.getFechaIngreso());
		h.setFechaDevolucion(b.getFechaDevolucion());
		return h;
	}

}
