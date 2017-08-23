package com.laplataenbici.model.repository;

import com.laplataenbici.model.domain.Localidad;
import com.laplataenbici.model.domain.exceptions.DBException;

public interface LocalidadRepository extends EntityRepository<Localidad>{
	
	Long countUsuarios(Localidad l) throws DBException;
}
