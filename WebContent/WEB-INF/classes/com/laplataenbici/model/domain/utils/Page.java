package com.laplataenbici.model.domain.utils;

import java.util.ArrayList;
import java.util.List;

public class Page<T>{
	private Integer size;
	private Integer pages;
	private Integer current;
	private List<T> items;
	
	public Page(Object empty){
		this.size = 0;
		this.pages = 0;
		this.current = 0;
		this.items = new ArrayList<T>();
	}
	
	public Page() {
		// TODO Auto-generated constructor stub
	}

	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		this.current = current;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}

	
}
