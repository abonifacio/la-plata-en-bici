package com.laplataenbici.model.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.repository.UsuarioRepository;
import com.laplataenbici.model.repository.utils.TransactionWrapper;

public class UsuarioRepositoryImpl extends EntityRepositoryImpl<Usuario> implements UsuarioRepository {

	@Override
	public Optional<Usuario> findOneByUsernameAndPassword(String username, String password) throws DBException{

		TransactionWrapper<Usuario> tw = new TransactionWrapper<Usuario>(){
			
			@Override
			public Usuario prepare(EntityManager em) {
				try{							
					return (Usuario) em.createQuery("from Usuario u where u.username = :user and u.password = :pass")
							.setParameter("user", username).setParameter("pass", password).getSingleResult();
				}catch(NoResultException e){
					return null;
				}
			}
			
		};
		return Optional.ofNullable(tw.go());

	}
	
	@Override
	public Optional<Usuario> findOneByEmail(String email) throws DBException {
		TransactionWrapper<Usuario> tw = new TransactionWrapper<Usuario>(){
			
			@Override
			public Usuario prepare(EntityManager em) {
				try{							
					return (Usuario) em.createQuery("from Usuario u where u.email = :email")
							.setParameter("email", email).getSingleResult();
				}catch(NoResultException e){
					return null;
				}
			}
			
		};
		return Optional.ofNullable(tw.go());
	}
	
	@Override
	public Optional<Usuario> findOneByUsername(String username) throws DBException {
		TransactionWrapper<Usuario> tw = new TransactionWrapper<Usuario>(){
			
			@Override
			public Usuario prepare(EntityManager em) {
				try{							
					return (Usuario) em.createQuery("from Usuario u where u.username = :username")
					.setParameter("username", username).getSingleResult();
				}catch(NoResultException e){
					return null;
				}
			}
			
		};
		return Optional.ofNullable(tw.go());
	}


}
