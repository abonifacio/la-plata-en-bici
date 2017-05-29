package com.laplataenbici.model.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Table;

import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public abstract class EntityRepository<T> implements IEntityRepository<T>{

	private final Class<T> entidad;
	
	

	@SuppressWarnings("unchecked")
	public EntityRepository(){
		entidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	@Override
	public Optional<T> findOneById(final Long id) throws DBException{
		TransactionWrapper<T> tw = new TransactionWrapper<T>(){

			@Override
			public T prepare(EntityManager em) {
				return (T) em.find(entidad, id);
			}
			
		};
		return Optional.ofNullable(tw.go());
	}

	@Override
	public Page<T> findAll(Pageable pageable) throws DBException{
		
		String tbl = entidad.getAnnotation(Table.class).name();
		FindAllHelper<T> fh = new FindAllHelper<>(pageable, tbl);
		return fh.go();
 	}
	
	@Override
	public T save(T entity) throws DBException{
		TransactionWrapper<T> tw = new TransactionWrapper<T>() {

			@Override
			public T prepare(EntityManager em) {
				em.persist(entity);
				return entity;
			}
			
		};
		
		return tw.go();
	}

}
