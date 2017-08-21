package com.laplataenbici.model.repository.impl;


import java.util.List;

import javax.persistence.EntityManager;

import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
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
	
	@Override
	public List<Bicicleta> getByUser(Usuario u) throws DBException {
		TransactionWrapper<List<Bicicleta>> tw = new TransactionWrapper<List<Bicicleta>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<Bicicleta> prepare(EntityManager em) {
				return (List<Bicicleta>) em.createQuery("from Bicicleta e where e.usuario = :user")
						.setParameter("user", u).getResultList();
			}
			
		};
		return tw.go();
	}
	
	@Override
	public Bicicleta getRandomBicicleta(Estacion e) throws DBException {
		TransactionWrapper<Bicicleta> tw = new TransactionWrapper<Bicicleta>(){
			
			@Override
			public Bicicleta prepare(EntityManager em) {
				@SuppressWarnings("unchecked")
				List<Bicicleta> b = (List<Bicicleta>) em.createQuery("from Bicicleta b where b.estacion.estado = :estadoE and b.estado = :estadoB and b.usuario = null")
						.setParameter("estadoE", EstadoEstacion.OPERATIVA)
						.setParameter("estadoB", EstadoBicicleta.APTA).setMaxResults(1)
						.getResultList();
				if(b.size()==0) return null;
				return b.get(0);
				
			}
			
		};
		return tw.go();
	}
	
}
