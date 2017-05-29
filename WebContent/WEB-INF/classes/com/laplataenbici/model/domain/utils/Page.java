package com.laplataenbici.model.domain.utils;

import java.util.List;

public class Page<T>{
	private Integer pageSize; // tamano de pagina
	private Integer pages; // total paginas
	private Integer currentPage; // pagina actual
	private Integer totalItems; // total resultados
	private List<T> items;
	
	public Page(Pageable pageable,Integer totalItems){
		this.pageSize = pageable.getCount();

		if(totalItems % pageable.getCount()==0){
			this.pages = totalItems/pageable.getCount();
		}else{
			this.pages = totalItems/pageable.getCount() + 1;
		}
		
		this.currentPage = pageable.getPage();
		this.items = null;
		this.totalItems = totalItems;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer size) {
		this.pageSize = size;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer current) {
		this.currentPage = current;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	
	

	
}
