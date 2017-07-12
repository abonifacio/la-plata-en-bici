package com.laplataenbici.model.services;

import java.util.Optional;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;

public abstract class AbstractEntityService <T extends AbstractEntity>{
	
	protected abstract EntityRepository<T> getRepo();
	
	
	
	public T create(T entity) throws LPBException{
		return this.getRepo().save(entity);
	}
	
	public T update(T entity) throws LPBException{
		this.get(entity.getId());
		
		return this.getRepo().save(entity);
	}
	
	public T get(Long id)throws LPBException{
		Optional<T> tmp = this.getRepo().findOneById(id);
		if(tmp.isPresent()){
			return tmp.get();
		}
		throw new BusinessException("No se encontró el dato");
	}
	
	public Page<T> findAll(Pageable pageable) throws DBException{
		return this.getRepo().findAll(pageable);
	}
	
	public void delete(Long id) throws DBException{
		this.getRepo().delete(id);
	}

}
