package com.laplataenbici.model.domain.tracking;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.laplataenbici.model.domain.Bicicleta;

@Entity
@Table(name="TrackingBicicleta")
public class TrackingBicicleta extends AbstractTracking<Bicicleta>{
	
	
}
