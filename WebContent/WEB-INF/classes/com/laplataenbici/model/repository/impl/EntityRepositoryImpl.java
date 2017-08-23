package com.laplataenbici.model.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.utils.FindAllHelper;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public abstract class EntityRepositoryImpl<T extends AbstractEntity> implements EntityRepository<T>{

	private final Class<T> entidad;
	protected final String tabla;
	protected final Map<String,Class<?>> allowedFields;
	

	@SuppressWarnings("unchecked")
	public EntityRepositoryImpl(){
		entidad = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		tabla = entidad.getAnnotation(Table.class).name();
		
		Field[] fields = entidad.getDeclaredFields();
		this.allowedFields = new HashMap<String,Class<?>>();
		for(Field f : fields){
			if(!f.isAnnotationPresent(Transient.class)){
				this.allowedFields.put(f.getName(),f.getClass());				
			}
		}
	}
	
	
	@Override
	public Optional<T> findOneById(final Long id) throws DBException{
		TransactionWrapper<T> tw = new TransactionWrapper<T>(){

			@Override
			public T prepare(EntityManager em) {
				return manage((T) em.find(entidad, id));
			}
			
		};
		return Optional.ofNullable(tw.go());
	}

	@Override
	public Page<T> findAll(Pageable pageable) throws DBException{
		
		FindAllHelper<T> fh = new FindAllHelper<T>(tabla,allowedFields){

			@Override
			protected List<T> afterResult(List<T> list) {
				return manage(list);
			}
			
		};
		return fh.go(pageable);
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
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>(){
			
			@Override
			public Long prepare(EntityManager em) {
				em.createQuery("delete from "+tabla+" e where e.id = :id").setParameter("id", id).executeUpdate();
				return id;
			}
			
		};
		
		return tw.go();
	}
	
	@Override
	public List<T> findAll() throws DBException{
		

		TransactionWrapper<List<T>> tw = new TransactionWrapper<List<T>>(){
			
			@SuppressWarnings("unchecked")
			@Override
			public List<T> prepare(EntityManager em) {
				return (List<T>) em.createQuery("from "+tabla)
				.getResultList();
			}
			
		};
		return tw.go();

	}
	
	@Override
	public Long countByEstado(Enum<?> estado) throws DBException {
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {

			@Override
			public Long prepare(EntityManager em) {
				return (Long) em.createQuery("select count(e) from "+tabla+" e where estado = :estado")
						.setParameter("estado", estado).getSingleResult();
			}
			
		};
		return tw.go();
	}
	
	@Override
	public Long count() throws DBException {
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {

			@Override
			public Long prepare(EntityManager em) {
				return (Long) em.createQuery("select count(e) from "+tabla+" e").getSingleResult();
			}
			
		};
		return tw.go();
	}


	public String getTabla() {
		return tabla;
	}


	public Map<String, Class<?>> getAllowedFields() {
		return allowedFields;
	}
	
	protected T manage(T entity){
		return entity;
	}
	
	protected List<T> manage(List<T> list){
		return list;
	}
	
	

}
