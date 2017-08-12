package com.laplataenbici.controllers.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.laplataenbici.controllers.resource.utils.AppConstants.QUERY;
import com.laplataenbici.controllers.resource.utils.AppConstants.URI;
import com.laplataenbici.controllers.resource.utils.LPBResponse;
import com.laplataenbici.model.domain.AbstractEntity;
import com.laplataenbici.model.domain.Bicicleta;
import com.laplataenbici.model.domain.Estacion;
import com.laplataenbici.model.domain.Usuario;
import com.laplataenbici.model.domain.exceptions.LPBException;
import com.laplataenbici.model.domain.tracking.AbstractTracking;
import com.laplataenbici.model.domain.tracking.OperacionTracking;
import com.laplataenbici.model.domain.utils.Page;
import com.laplataenbici.model.domain.utils.Pageable;
import com.laplataenbici.model.repository.utils.query.TrackingQuery;
import com.laplataenbici.model.services.tracking.AbstractTrackingService;
import com.laplataenbici.model.services.tracking.TrackingBicicletaService;
import com.laplataenbici.model.services.tracking.TrackingEstacionService;
import com.laplataenbici.model.services.tracking.TrackingUsuarioService;

@Path(URI.TRACKING)
@Produces(MediaType.APPLICATION_JSON)
public class TrackingResource {
	
	private TrackingUsuarioService usuarios = new TrackingUsuarioService();
	private TrackingBicicletaService bicicletas = new TrackingBicicletaService();
	private TrackingEstacionService estaciones = new TrackingEstacionService();
	
	@GET
	@Path("/{tracking}")
	public Response getAllUsuarios(
			@PathParam("tracking")String tipo,
			@QueryParam(QUERY.PAGE) @DefaultValue("0") Integer page,
			@QueryParam(QUERY.COUNT) @DefaultValue("25") Integer size,
			@QueryParam(QUERY.SORT) @DefaultValue("id") String sort,
			@QueryParam(QUERY.ASC) @DefaultValue("false") Boolean ascending,
			@QueryParam("desde") Long desde,
			@QueryParam("hasta") Long hasta,
			@QueryParam("usuario") Long user,
			@QueryParam("entidad") Long entidad,
			@QueryParam("operacion") OperacionTracking operacion) throws LPBException {
		
		Pageable pageable = new Pageable(page, size,sort,ascending);
		
		TrackingQuery<AbstractEntity> query = new TrackingQuery<AbstractEntity>(operacion, desde, hasta, user, getEntidad(tipo,entidad));
		
		 Page<? extends AbstractTracking<?>> res = getService(tipo).findByQuery(query, pageable);
		
		return LPBResponse.ok(res);
	}
	
	private AbstractTrackingService<?> getService(String tipo){
		switch(tipo){
			case "Usuario":
				return usuarios;
			case "Bicicleta":
				return bicicletas;
			case "Estacion":
				return estaciones;
			default:
				return null;
		}
	}
	
	private AbstractEntity getEntidad(String tipo,Long id){
		if(id==null) return null;
		switch(tipo){
		case "Usuario":
			return new Usuario(id);
		case "Bicicleta":
			return new Bicicleta(id);
		case "Estacion":
			return new Estacion(id);
		default:
			return null;
	}
	}
}
