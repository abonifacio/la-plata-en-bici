package com.laplataenbici.model.services;

import java.util.Optional;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.FordibbenException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.UsuarioRepository;
import com.laplataenbici.model.repository.impl.UsuarioRepositoryImpl;
import com.laplataenbici.model.services.tracking.AbstractTrackableService;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingUsuarioService;

public class UsuarioService extends AbstractTrackableService<Usuario, TrackingUsuario>{
	
	private UsuarioRepository repo= new UsuarioRepositoryImpl();
	
	private TrackingUsuarioService trackingService = new TrackingUsuarioService();

	@Override
	protected EntityRepository<Usuario> getRepo() {
		return repo;
	}
	
	@Override
	public Usuario create(Usuario entity) throws LPBException{
		if(entity.getLocalidad()==null || entity.getLocalidad().getId()==null){
			throw new BusinessException("El usuario debe tener asociada una localidad");
		}
		entity.setRol(Rol.USER);
		return super.create(entity);
	}
	
	public Optional<Usuario> findOneByUsernameAndPassword(String username,String password) throws LPBException{
		return repo.findOneByUsernameAndPassword(username, password);
	}
	
	public Usuario login(Usuario user) throws LPBException{
		Optional<Usuario> tmp = repo.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(tmp.isPresent()){
			return tmp.get();
		}
		throw new FordibbenException("Combinación de usuario/contraseña incorrecta");
	}
	
	public Usuario setActivo(Long id, EstadoUsuario estado) throws LPBException{
		Usuario tmp = this.get(id);
		tmp.setEstado(estado);
		return super.update(tmp);
	}

	@Override
	public TrackingUsuario createTracking() {
		return new TrackingUsuario();
	}

	@Override
	public AbstractTrackingService<TrackingUsuario> getTrackingService() {
		return trackingService;
	}
	
	
}
