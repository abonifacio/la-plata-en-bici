package com.laplataenbici.model.repository.interfaces.tracking;

import java.util.Date;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.interfaces.IEntityRepository;

public interface ITrackingRepository<T> extends IEntityRepository<T>{
	
	Page<T> findByUsuario(Usuario user, Pageable page);
	Page<T> findByFecha(Date fecha, Pageable page);
	Page<T> findByOperacion(Enum<?> operacion, Pageable page);
}
