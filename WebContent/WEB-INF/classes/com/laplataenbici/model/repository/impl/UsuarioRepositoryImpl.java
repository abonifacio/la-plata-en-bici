package com.laplataenbici.model.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;

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
				return (Usuario) em.createQuery("select from Usuario u where u.username = :user and u.password :pass")
				.setParameter("user", username).setParameter("pass", password).getSingleResult();
			}
			
		};
		return Optional.ofNullable(tw.go());

	}


}
