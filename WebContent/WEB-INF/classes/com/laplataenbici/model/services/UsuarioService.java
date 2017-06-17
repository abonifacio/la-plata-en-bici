package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Usuario;
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
	
	
	
}