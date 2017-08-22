package com.laplataenbici.model.repository.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;

public abstract class FindAllHelper<T extends AbstractEntity>{

	private final String tabla;
	private final Map<String,Class<?>> allowedFields;
	
	
	public FindAllHelper(String tabla,Map<String,Class<?>> allowedFields){
		this.tabla = tabla;
		this.allowedFields = allowedFields;
	}

	
	public Page<T> go(Pageable pageable, String query,Map<String,Object> params) throws DBException {
		if(query==null){
			query="";
			params = new HashMap<>();
		}else{
			query=" where "+query;
		}
		Page<T> page = new Page<T>(pageable,this.count(query,params).intValue());
		page.setItems(this.results(pageable,query,params));
		return page;
	}
	
	public Page<T> go(Pageable pageable) throws DBException{
		return this.go(pageable, null, null);
	}
		
	private Long count(String where,Map<String,Object> params) throws DBException{
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {
			@Override
			public Long prepare(EntityManager em) {
				
				return (Long) parse(em.createQuery("select count(e.id) from "+tabla+" e"+where),params)
						.getSingleResult();
			}
		};
		return tw.go();
	}
	
	private List<T> results(Pageable page, String where,Map<String,Object> params) throws DBException{
		TransactionWrapper<List<T>> tw = new TransactionWrapper<List<T>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<T> prepare(EntityManager em) {
				String query = "from "+tabla+" e" + where;
				String[] tmp = page.getSort().split("\\.");
				String sort = tmp.length>0 ? tmp[0] : page.getSort();
				if(allowedFields.containsKey(sort)){
					String direction = page.isAscending() ? "ASC ": "DESC";
					query = query + " order by e."+page.getSort()+" "+direction;
				}
				return afterResult(
						(List<T>) parse(em.createQuery(query),params)
						.setFirstResult(page.getPage()*page.getCount())
						.setMaxResults(page.getCount()).getResultList()
						);
			}
			
		};
		
		return tw.go();
	}
	
	private Query parse(Query q, Map<String,Object> params){
		for(String key : params.keySet()){
			q.setParameter(key, params.get(key));
		}
		return q;
	}
	
	protected abstract List<T> afterResult(List<T> list);
	

}
