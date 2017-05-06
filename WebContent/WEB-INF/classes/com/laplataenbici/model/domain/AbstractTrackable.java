package com.laplataenbici.model.domain;

import java.util.List;

public class AbstractTrackable<T> extends AbstractEntity{
	
	protected List<T> tracking;

	public List<T> getTracking() {
		return tracking;
	}

	public void setTracking(List<T> tracking) {
		this.tracking = tracking;
	}
	
	
	
}
