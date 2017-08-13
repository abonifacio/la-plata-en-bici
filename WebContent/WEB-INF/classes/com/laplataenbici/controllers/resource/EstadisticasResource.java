package com.laplataenbici.controllers.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.laplataenbici.controllers.resource.utils.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.utils.EstadisticasDTO;
import com.laplataenbici.model.domain.utils.EstadoBicicleta;
import com.laplataenbici.model.domain.utils.EstadoEstacion;
import com.laplataenbici.model.domain.utils.EstadoUsuario;
import com.laplataenbici.model.domain.utils.Rol;
import com.laplataenbici.model.services.BicicletaService;
import com.laplataenbici.model.services.EstacionService;
import com.laplataenbici.model.services.UsuarioService;
import com.laplataenbici.security.Secured;

@Path(URI.ESTADISTICAS)
@Produces(MediaType.APPLICATION_JSON)
public class EstadisticasResource {

	private final UsuarioService usuarios = new UsuarioService();
	private final BicicletaService bicicletas = new BicicletaService();
	private final EstacionService estaciones = new EstacionService();
	
	@GET
	@Secured(Rol.ADMIN)
	public Response getEstadisticas() throws LPBException {
		EstadisticasDTO dto = new EstadisticasDTO();

		
		for(EstadoUsuario e : EstadoUsuario.values()){
			dto.setCantidadEstado(e, usuarios.countByEstado(e));
		}
		for(EstadoBicicleta e : EstadoBicicleta.values()){
			dto.setCantidadEstado(e, bicicletas.countByEstado(e));
		}
		for(EstadoEstacion e : EstadoEstacion.values()){
			dto.setCantidadEstado(e, estaciones.countByEstado(e));
		}
		dto.setBicicletasAlquiladas(bicicletas.countAlquiladas());
		dto.setBicicletas(bicicletas.count());
		dto.setEstaciones(estaciones.count());
		dto.setUsuarios(usuarios.count());
		
		return LPBResponse.ok(dto);
	}
	
	
}
