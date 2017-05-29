package com.laplataenbici.model.repository.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.laplataenbici.model.domain.exceptions.DBException;


public abstract class TransactionWrapper<T> {
	private EntityManager em;
	private EntityTransaction tx;
	
	
	public abstract T prepare(EntityManager em);
	

	public T go() throws DBException{
		try{
			em = SessionUtils.getManager();
			tx = em.getTransaction();
			tx.begin();
			T tmp = prepare(em);
			tx.commit();
			em.close();
			return tmp;
		}catch(Exception e){
			e.printStackTrace();
			throw new DBException("Hubo un error al acceder a la base de datos");
		}
	}
	
}
