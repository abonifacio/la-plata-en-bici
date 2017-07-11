package com.laplataenbici.model.domain.utils;

public class Pageable {
	private Integer page;
	private Integer count;
	private String sort;
	private Boolean ascending;
	private String search;
	private String searchValue;
	
	public Pageable(Integer page, Integer count){
		this.page = page;
		this.count = count;
	}
	public Pageable(Integer page, Integer count,String sort, Boolean ascending){
		this(page,count);
		this.sort = sort;
		this.ascending = ascending;
	}
	public Pageable(Integer page, Integer count,String sort, Boolean ascending,String search, String searchValue){
		this(page,count,sort,ascending);
		this.search = search;
		this.searchValue = searchValue;
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
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	
	
	
	
	
}
