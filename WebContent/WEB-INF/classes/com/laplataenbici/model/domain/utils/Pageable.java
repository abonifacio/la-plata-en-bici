package com.laplataenbici.model.domain.utils;

public class Pageable {
	private Integer page;
	private Integer count;

	public Pageable(Integer page, Integer count){
		this.page = page;
		this.count = count;
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
	
	
}
