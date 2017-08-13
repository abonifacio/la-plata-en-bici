package com.laplataenbici.model.repository.impl;


import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.repository.BicicletaRepository;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public class BicicletaRepositoryImpl extends EntityRepositoryImpl<Bicicleta> implements BicicletaRepository{

	@Override
	public Long countAlquiladas() throws DBException {
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {

			@Override
			public Long prepare(EntityManager em) {
				return (Long) em.createQuery("select count(e) from Bicicleta e where e.fechaDevolucion != null").getSingleResult();
			}
			
		};
		return tw.go();
	}
	
	

}
