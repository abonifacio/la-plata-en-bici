package com.laplataenbici.model.repository.impl;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.Localidad;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.repository.LocalidadRepository;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public class LocalidadRepositoryImpl extends EntityRepositoryImpl<Localidad> implements LocalidadRepository {

	@Override
	public Long countUsuarios(Localidad l) throws DBException {
		TransactionWrapper<Long> tw = new TransactionWrapper<Long>() {

			@Override
			public Long prepare(EntityManager em) {
				return (Long) em.createQuery("select count(u) from Usuario u where u.localidad = :loc")
						.setParameter("loc", l).getSingleResult();
			}
			
		};
		return tw.go();
	}

	

}
