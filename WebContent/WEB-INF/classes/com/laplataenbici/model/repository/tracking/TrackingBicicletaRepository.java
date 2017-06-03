package com.laplataenbici.model.repository.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingBicicleta;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.interfaces.tracking.ITrackingBicicletaRepository;

public class TrackingBicicletaRepository extends EntityRepository<TrackingBicicleta> implements ITrackingBicicletaRepository{

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
