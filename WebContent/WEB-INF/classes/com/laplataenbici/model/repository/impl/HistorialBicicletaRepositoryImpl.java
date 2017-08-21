package com.laplataenbici.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.HistorialBicicleta;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.repository.HistorialBicicletaRepository;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public class HistorialBicicletaRepositoryImpl extends EntityRepositoryImpl<HistorialBicicleta> implements HistorialBicicletaRepository{

	@Override
	public List<HistorialBicicleta> findAllFor(Bicicleta b) throws DBException {
		TransactionWrapper<List<HistorialBicicleta>> tw = new TransactionWrapper<List<HistorialBicicleta>>() {

			@Override
			@SuppressWarnings("unchecked")
			public List<HistorialBicicleta> prepare(EntityManager em) {
				return (List<HistorialBicicleta>) 
						em.createQuery("from HistorialBicicleta h where h.bicicleta = :bici")
						.setParameter("bici", b).getResultList();
			}
			
		};
		return tw.go();

	}

}
