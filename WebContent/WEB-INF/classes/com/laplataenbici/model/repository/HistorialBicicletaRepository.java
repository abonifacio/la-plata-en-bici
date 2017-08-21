package com.laplataenbici.model.repository;

import java.util.List;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;

public interface HistorialBicicletaRepository extends EntityRepository<HistorialBicicleta>{
	
	List<HistorialBicicleta> findAllFor(Bicicleta b) throws DBException;
	
}
