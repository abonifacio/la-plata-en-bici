package com.laplataenbici.model.repository.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingEstacion;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.interfaces.tracking.ITrackingEstacionRepository;

public class TrackingEstacionRepository extends EntityRepository<TrackingEstacion> implements ITrackingEstacionRepository {

	@Override
	public Page<TrackingEstacion> findByUsuario(Usuario user, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingEstacion> findByFecha(Date fecha, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingEstacion> findByOperacion(Enum<?> operacion, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}



}
