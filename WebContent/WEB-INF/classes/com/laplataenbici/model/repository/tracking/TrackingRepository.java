package com.laplataenbici.model.repository.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.EntityRepository;

public interface TrackingRepository<T> extends EntityRepository<T>{
	
	Page<T> findByUsuario(Usuario user, Pageable page);
	Page<T> findByFecha(Date fecha, Pageable page);
	Page<T> findByOperacion(Enum<?> operacion, Pageable page);
}