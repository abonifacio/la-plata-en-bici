package com.laplataenbici.model.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	protected Long id;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public AbstractEntity(){
		
	}

	public AbstractEntity(Long id) {
		this.id = id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof AbstractEntity && ((AbstractEntity)obj).getId().equals(id);
	}
	
}
