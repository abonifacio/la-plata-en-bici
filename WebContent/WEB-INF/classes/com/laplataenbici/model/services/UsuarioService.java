package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.repository.UsuarioRepository;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;
import com.laplataenbici.model.repository.interfaces.IUsuarioRepository;

public class UsuarioService extends AbstractEntityService<Usuario>{
	
	private IUsuarioRepository repo;
	
	public UsuarioService(){
		repo = new UsuarioRepository();
	}
	
	@Override
	protected IEntityRepository<Usuario> getRepo() {
		return repo;
	}
	
	@Override
	public Usuario create(Usuario entity) throws LPBException{
		if(entity.getLocalidad()==null || entity.getLocalidad().getId()==null){
			throw new BusinessException("El usuario debe tener asociada una localidad");
		}
		return super.create(entity);
	}
	
	
	
}
