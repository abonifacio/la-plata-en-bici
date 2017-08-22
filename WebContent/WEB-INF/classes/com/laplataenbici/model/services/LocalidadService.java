package com.laplataenbici.model.services;

import com.laplataenbici.model.domain.Localidad;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.LocalidadRepository;
import com.laplataenbici.model.repository.impl.LocalidadRepositoryImpl;

public class LocalidadService extends AbstractEntityService<Localidad> {

	private LocalidadRepository repo = new LocalidadRepositoryImpl();
	
	@Override
	protected EntityRepository<Localidad> getRepo() {
		return repo;
	}
	
	@Override
	public void checkDelete(Localidad e) throws LPBException {
		if(repo.countUsuarios(e)>0){
			throw new BusinessException("La localidad no se puede borrar porque hay usuarios con domicilo en esta");
		}
	}

}
