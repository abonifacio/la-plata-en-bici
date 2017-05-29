package com.laplataenbici.model.repository.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionUtils {

	
	private static EntityManagerFactory emf;

	
	private static EntityManagerFactory getFactory(){
		if(emf==null){
			emf = Persistence.createEntityManagerFactory("LaPlataEnBici");
		}
		return emf;
	}
		
	
	public static EntityManager getManager(){
		return getFactory().createEntityManager();
	}
	
}
