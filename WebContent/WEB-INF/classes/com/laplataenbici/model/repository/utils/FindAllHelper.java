package com.laplataenbici.model.repository.utils;

import java.util.List;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public class FindAllHelper<T>{

	private Pageable request;
	private String tabla;
	public FindAllHelper(Pageable request,String tabla){
		this.request = request;
		this.tabla = tabla;
	}

	
	public Page<T> go() throws DBException {
		Page<T> page = new Page<T>(request,this.count());
		page.setItems(this.results());
		return page;
	}
		
	private Integer count() throws DBException{
		TransactionWrapper<Integer> tw = new TransactionWrapper<Integer>() {
			@Override
			public Integer prepare(EntityManager em) {
				return (Integer) em.createQuery("select count e.id from :tabla e")
						.setParameter("tabla", tabla)
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
				return (List<T>) em.createQuery("from :tabla")
						.setFirstResult(request.getPage()*request.getCount())
						.setMaxResults(request.getCount()).getResultList();
			}
			
		};
		
		return tw.go();
	}
	

}
