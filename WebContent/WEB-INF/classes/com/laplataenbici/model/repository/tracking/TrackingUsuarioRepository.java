package com.laplataenbici.model.repository.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.interfaces.tracking.ITrackingUsuarioRepository;

public class TrackingUsuarioRepository extends EntityRepository<TrackingUsuario> implements ITrackingUsuarioRepository {

	@Override
	public Page<TrackingUsuario> findByUsuario(Usuario user, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingUsuario> findByFecha(Date fecha, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<TrackingUsuario> findByOperacion(Enum<?> operacion, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}


}
