package com.laplataenbici.model.repository.impl.tracking;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.repository.tracking.TrackingBicicletaRepository;

public class TrackingBicicletaRepositoryImpl extends AbstractTrackingRepositoryImpl<TrackingBicicleta> implements TrackingBicicletaRepository{

	@Override
	public Page<Bicicleta> alquiladasPor(Usuario u) {
		// TODO Auto-generated method stub
		return null;
	}


}
