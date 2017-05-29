package com.laplataenbici.model.repository.interfaces;

import java.util.Optional;

import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public interface IEntityRepository<T> {
			
	public Optional<T> findOneById(Long id) throws DBException;
	
	public Page<T> findAll(Pageable page) throws DBException;
	
	public T save(T entity) throws DBException;
	
}
