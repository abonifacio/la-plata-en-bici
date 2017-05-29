package com.laplataenbici.model.domain;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class AbstractTrackable<T> extends AbstractEntity{

//	@OneToMany(fetch=FetchType.LAZY)
//	protected List<T> tracking;
//
//	public List<T> getTracking() {
//		return tracking;
//	}
//
//	public void setTracking(List<T> tracking) {
//		this.tracking = tracking;
//	}
	
	
	
}
