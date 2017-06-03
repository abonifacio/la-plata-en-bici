package com.laplataenbici.model.repository.utils;

import java.util.List;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public class FindAllHelper<T extends AbstractEntity>{

	private Pageable request;
	private String tabla;
	public FindAllHelper(Pageable request,String tabla){
		this.request = request;
		this.tabla = tabla;
	}

	
	public Page<T> go() throws DBException {
		Page<T> page = new Page<T>(request,this.count().intValue());
		page.setItems(this.results());
		return page;
	}
		
	private Long count() throws DBException{
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {
			@Override
			public Long prepare(EntityManager em) {
				return (Long) em.createQuery("select count(e.id) from "+tabla+" e")
				.getSingleResult();
			}
		};
		return tw.go();
	}
	
	private List<T> results() throws DBException{
		TransactionWrapper<List<T>> tw = new TransactionWrapper<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> prepare(EntityManager em) {
				return (List<T>) em.createQuery("from "+tabla)
						.setFirstResult(request.getPage()*request.getCount())
						.setMaxResults(request.getCount()).getResultList();
			}
			
		};
		
		return tw.go();
	}
	

}
