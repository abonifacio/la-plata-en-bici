package com.laplataenbici.model.domain.tracking;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.laplataenbici.model.domain.Estacion;

@Entity
@Table(name="TrackingEstacion")
public class TrackingEstacion extends AbstractTracking<Estacion> {
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof TrackingEstacion && super.equals(obj);
	}
}
