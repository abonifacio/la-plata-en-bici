package com.laplataenbici.model.repository.utils;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public class FindAllHelper<T extends AbstractEntity>{

	private final Pageable request;
	private final String tabla;
	private final Map<String,Class<?>> allowedFields;
	
	public FindAllHelper(Pageable request,String tabla,Map<String,Class<?>> allowedFields){
		this.request = request;
		this.tabla = tabla;
		this.allowedFields = allowedFields;
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
				String query = "from "+tabla+" e";
				if(allowedFields.containsKey(request.getSort())){
					String direction = request.isAscending() ? "ASC ": "DESC";
					query = query + " order by e."+request.getSort()+" "+direction;
				}
//				if(allowedFields.containsKey(request.getSearch())){
//					if(allowedFields.get(request.getSearch()).equals(String.class)){
//						query = query + " where "+request.getSearch()+" LIKE '%"+request.getSearchValue()+"%'";
//					}else{
//						query = query + " where "+request.getSearch()+" = "+request.getSearchValue()+"'";
//					}
//				}
				return (List<T>) em.createQuery(query)
						.setFirstResult(request.getPage()*request.getCount())
						.setMaxResults(request.getCount()).getResultList();
			}
			
		};
		
		return tw.go();
	}
	

}
