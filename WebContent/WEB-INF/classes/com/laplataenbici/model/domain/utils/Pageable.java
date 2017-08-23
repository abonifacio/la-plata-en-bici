package com.laplataenbici.model.domain.utils;

import javax.ws.rs.core.MultivaluedMap;

import com.laplataenbici.config.AppConstants.QUERY;

public class Pageable {
	private Integer page;
	private Integer count;
	private String sort;
	private Boolean ascending;
	
	public Pageable(Integer page, Integer count){
		this.page = page==null ? 0 : page;
		this.count = count==null? 25: count;
	}
	public Pageable(Integer page, Integer count,String sort, Boolean ascending){
		this(page,count);
		this.sort = sort==null? "id": sort;
		this.ascending = ascending==null ? false: ascending;
	}
	
	public Pageable(MultivaluedMap<String,String> params){
		this.page = Integer.valueOf(params.getFirst(QUERY.PAGE));
		this.count = Integer.valueOf(params.getFirst(QUERY.COUNT));
		this.sort = params.getFirst(QUERY.SORT);
		this.ascending = Boolean.valueOf(params.getFirst(QUERY.ASC));
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Boolean isAscending() {
		return ascending;
	}

	public void setAscending(Boolean ascending) {
		this.ascending = ascending;
	}
	
	
	
}
