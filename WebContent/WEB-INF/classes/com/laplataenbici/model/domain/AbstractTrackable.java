package com.laplataenbici.model.domain;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractTrackable extends AbstractEntity{

	public AbstractTrackable() {
		super();
	}

	public AbstractTrackable(Long id) {
		super(id);
	}

	
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
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof AbstractTrackable && super.equals(obj);
	}
	
	
	
}
