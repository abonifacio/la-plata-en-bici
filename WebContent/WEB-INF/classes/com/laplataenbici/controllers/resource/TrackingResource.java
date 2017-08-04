package com.laplataenbici.controllers.resource;

import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.laplataenbici.controllers.resource.utils.ApiConstants;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.services.UsuarioService;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingBicicletaService;
import com.laplataenbici.model.services.tracking.TrackingEstacionService;
import com.laplataenbici.model.services.tracking.TrackingUsuarioService;

@Path(ApiConstants.TRACKING_URI)
@Produces(MediaType.APPLICATION_JSON)
public class TrackingResource {
	
	private TrackingUsuarioService usuarios = new TrackingUsuarioService();
	private UsuarioService usuario = new UsuarioService();
	private TrackingBicicletaService bicicletas = new TrackingBicicletaService();
	private TrackingEstacionService estaciones = new TrackingEstacionService();
	
	@GET()
	@Path("/{tracking}")
	public Response getAllUsuarios(
			@PathParam("tracking")TipoTracking tipo,
			@QueryParam("page") @DefaultValue("0") Integer page,
			@QueryParam("size") @DefaultValue("25") Integer size,
			@QueryParam("sort") @DefaultValue("id") String sort,
			@QueryParam("ascending") @DefaultValue("false") Boolean ascending,
			@QueryParam("fecha") Date fecha,
			@QueryParam("usuario") Long user,
			@QueryParam("operacion") OperacionTracking operacion) throws LPBException {
		
		Pageable pageable = new Pageable(page, size,sort,ascending);
		
		Page<? extends AbstractTracking<?>> res;
		
		if(fecha!=null){
			res = getService(tipo).findByFecha(fecha, pageable);
		}else if(operacion!=null){
			res = getService(tipo).findByOperacion(operacion, pageable);
		}else if(user!=null){
			Usuario u = usuario.get(user);
			res = getService(tipo).findByUsuario(u, pageable);
		}else{
			res = getService(tipo).findAll(pageable);
		}
		
		return LPBResponse.ok(res);
	}
	
	private AbstractTrackingService<?> getService(TipoTracking tipo){
		switch(tipo){
		case USUARIO:
			return usuarios;
		case BICICLETA:
			return bicicletas;
		case ESTACION:
			return estaciones;
		default:
			return null;
		}
	}
	
	enum TipoTracking{
		USUARIO,BICICLETA,ESTACION;
	}

}
