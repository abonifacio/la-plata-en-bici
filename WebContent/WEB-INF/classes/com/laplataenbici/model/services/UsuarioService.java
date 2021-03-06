package com.laplataenbici.model.services;

import java.util.Optional;

import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.BusinessException;
import com.laplataenbici.model.domain.exceptions.DBException;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.PasswordDTO;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.repository.EntityRepository;
import com.laplataenbici.model.repository.UsuarioRepository;
import com.laplataenbici.model.repository.impl.UsuarioRepositoryImpl;
import com.laplataenbici.security.SecurityUtils;

public class UsuarioService extends AbstractEntityService<Usuario>{
	
	private UsuarioRepository repo= new UsuarioRepositoryImpl();
	

	@Override
	protected EntityRepository<Usuario> getRepo() {
		return repo;
	}
	
	@Override
	public Usuario create(Usuario entity) throws LPBException{
		if(entity.getLocalidad()==null || entity.getLocalidad().getId()==null){
			throw new BusinessException("El usuario debe tener asociada una localidad");
		}
		entity.setPassword(SecurityUtils.randomPass());
		entity.setRol(Rol.USER);
		entity.setEstado(EstadoUsuario.HABILITADO);
		return super.create(entity);
	}
	
	public Optional<Usuario> findOneByUsernameAndPassword(String username,String password) throws LPBException{
		return repo.findOneByUsernameAndPassword(username, password);
	}
	
	public Usuario login(Usuario user) throws LPBException{
		Optional<Usuario> tmp = repo.findOneByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(tmp.isPresent()){
			return tmp.get();
		}
		throw new BusinessException("Combinación de usuario/contraseña incorrecta");
	}
	
	public Usuario setActivo(Long id, EstadoUsuario estado) throws LPBException{
		Usuario tmp = this.get(id);
		if(tmp.getRol().equals(Rol.ADMIN) && !estado.equals(EstadoUsuario.HABILITADO)){
			throw new BusinessException("No se puede suspender a un Administrador");
		}
		tmp.setEstado(estado);
		return super.update(tmp);
	}
	
	public Usuario setRol(Long id, Rol rol) throws LPBException{
		Usuario tmp = this.get(id);
		tmp.setRol(rol);
		return super.update(tmp);
	}
	
	public boolean isUsernameAvailable(String username) throws DBException{
		return !repo.findOneByUsername(username).isPresent();
	}
	
	public boolean isEmailAvailable(String email) throws DBException{
		return !repo.findOneByEmail(email).isPresent();
	}

	@Override
	public void checkDelete(Usuario e) throws LPBException {
		throw new BusinessException("Lo usuarios no se pueden borrar");
	}

	public Usuario changePassword(PasswordDTO password,Usuario cUser) throws LPBException{
		if(!cUser.getPassword().equals(password.getAnterior())){
			throw new BusinessException("La contraseña actual no es correcta");
		}
		if(!password.getNueva().equals(password.getConfirmacion())){
			throw new BusinessException("La contraseña de confirmación no conincide con la nueva");			
		}
		cUser.setPassword(password.getNueva());
		return super.update(cUser);
	}
	
}
