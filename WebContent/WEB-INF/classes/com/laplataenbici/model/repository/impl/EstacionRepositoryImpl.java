package com.laplataenbici.model.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
import com.laplataenbici.model.repository.EstacionRepository;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public class EstacionRepositoryImpl extends EntityRepositoryImpl<Estacion> implements EstacionRepository{

	@Override
	public List<Estacion> findAllByEstado(EstadoEstacion estado) throws DBException {
		TransactionWrapper<List<Estacion>> tw = new TransactionWrapper<List<Estacion>>(){
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Estacion> prepare(EntityManager em) {
				return (List<Estacion>) em.createQuery("from Estacion e where e.estado = :estado").setParameter("estado", estado)
				.getResultList();
			}
			
		};
		return tw.go();
	}

	@Override
	public List<Estacion> findAvailables() throws DBException {
			TransactionWrapper<List<Estacion>> tw = new TransactionWrapper<List<Estacion>>(){
			
			@SuppressWarnings("unchecked")
			@Override
			public List<Estacion> prepare(EntityManager em) {
				return (List<Estacion>) em.createQuery("select e from Estacion e join e.bicicletas b where e.estado = :estadoE and b.estado = :estadoB")
						.setParameter("estadoE", EstadoEstacion.OPERATIVA)
						.setParameter("estadoB", EstadoBicicleta.APTA)
				.getResultList();
			}
			
		};
		return tw.go();
	}
}
