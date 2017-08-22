package com.laplataenbici.model.repository;


import java.util.List;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.DBException;

public interface BicicletaRepository extends EntityRepository<Bicicleta>{
	
	public Long countAlquiladas() throws DBException;

	List<Bicicleta> getByUser(Usuario u) throws DBException;
	
	Bicicleta getRandomBicicleta(Estacion e) throws DBException;
}
