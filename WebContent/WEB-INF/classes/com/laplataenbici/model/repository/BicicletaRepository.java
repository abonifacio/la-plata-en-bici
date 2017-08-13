package com.laplataenbici.model.repository;


import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;

public interface BicicletaRepository extends EntityRepository<Bicicleta>{
	
	public Long countAlquiladas() throws DBException;
}
