package com.laplataenbici.model.repository;

import java.util.List;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.EstadoEstacion;

public interface EstacionRepository extends EntityRepository<Estacion>{
	List<Estacion> findAllByEstado(EstadoEstacion estado) throws DBException;
}
