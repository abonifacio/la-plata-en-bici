package com.laplataenbici.model.repository.impl.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.impl.EntityRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingBicicletaRepository;

public class TrackingBicicletaRepositoryImpl extends EntityRepositoryImpl<TrackingBicicleta> implements TrackingBicicletaRepository{

	@Override
	public Page<TrackingBicicleta> findByUsuario(Usuario user, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingBicicleta> findByFecha(Date fecha, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingBicicleta> findByOperacion(Enum<?> operacion, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
