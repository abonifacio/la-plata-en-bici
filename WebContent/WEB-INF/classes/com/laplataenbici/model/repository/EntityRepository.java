package com.laplataenbici.model.repository;

import java.util.List;
import java.util.Optional;

import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.repository.utils.query.BaseQuery;

public interface EntityRepository<T> {
			
	public Optional<T> findOneById(Long id) throws DBException;
	
	public Page<T> findAll(BaseQuery page) throws DBException;
	
	public T save(T entity) throws DBException;
	
	public Long delete(Long id) throws DBException;
	
	List<T> findAll() throws DBException;
	
	public Long countByEstado(Enum<?> estado) throws DBException;
	
	public Long count() throws DBException;
	
}
