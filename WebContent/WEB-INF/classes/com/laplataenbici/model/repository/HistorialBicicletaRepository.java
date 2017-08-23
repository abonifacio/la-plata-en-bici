package com.laplataenbici.model.repository;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.repository.utils.query.BaseQuery;

public interface HistorialBicicletaRepository extends EntityRepository<HistorialBicicleta>{
	
	Page<HistorialBicicleta> findAllFor(BaseQuery pageable,Bicicleta b) throws DBException;
	
}
