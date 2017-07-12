package com.laplataenbici.model.repository;


import java.util.Optional;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.DBException;

public interface UsuarioRepository extends EntityRepository<Usuario>{
	Optional<Usuario> findOneByUsernameAndPassword(String username,String password) throws DBException; 
}
