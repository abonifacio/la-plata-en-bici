package com.laplataenbici.model.repository;

import java.lang.reflect.ParameterizedType;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Table;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public abstract class EntityRepository<T extends AbstractEntity> implements IEntityRepository<T>{

	private final Class<T> entidad;
	private final String tabla;
	

	@SuppressWarnings("unchecked")
	public EntityRepository(){
		entidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		tabla = entidad.getAnnotation(Table.class).name();
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
		
		FindAllHelper<T> fh = new FindAllHelper<>(pageable, tabla);
		return fh.go();
 	}
	
	@Override
	public T save(T entity) throws DBException{
		TransactionWrapper<T> tw = new TransactionWrapper<T>() {

			@Override
			public T prepare(EntityManager em) {
				if(entity.getId()==null){
					em.persist(entity);					
				}else{
					em.merge(entity);
				}
				return entity;
			}
			
		};
		
		return tw.go();
	}
	
	@Override
	public Long delete(final Long id) throws DBException{
		final Optional<T> entity = this.findOneById(id);
		if(entity.isPresent()){
			
			TransactionWrapper<Long> tw = new TransactionWrapper<Long>(){
				
				@Override
				public Long prepare(EntityManager em) {
					em.createQuery("delete from "+tabla+" e where e.id = :id").setParameter("id", id).executeUpdate();
					return id;
				}
				
			};
			
			return tw.go();
			
		}else{
			throw new DBException("No se encontron el id a borrar -> "+id);
		}
	}

}
