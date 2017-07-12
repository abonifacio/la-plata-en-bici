package com.laplataenbici.model.repository.impl.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.tracking.TrackingUsuario;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.impl.EntityRepositoryImpl;
import com.laplataenbici.model.repository.tracking.TrackingUsuarioRepository;

public class TrackingUsuarioRepositoryImpl extends EntityRepositoryImpl<TrackingUsuario> implements TrackingUsuarioRepository {

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
