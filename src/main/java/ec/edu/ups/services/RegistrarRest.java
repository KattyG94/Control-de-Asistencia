package ec.edu.ups.services;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import ec.edu.ups.modelo.Asistencia;
import ec.edu.ups.modelo.Matricula;
import ec.edu.ups.on.AsistenciaON;
import ec.edu.ups.on.GrupoON;
import ec.edu.ups.on.MatriculaON;
@Path("/MyRest")
@ApplicationPath("/resources")
public class RegistrarRest extends Application{
	
	    @Inject
	    private AsistenciaON aON;
	    @Inject
	    private MatriculaON mON;
	@POST
	@Path("/registrarAsistencia")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertAsistencia(Asistencia asistencia) {
		ResponseBuilder builder=null;
		Map<String, String>data=new HashMap<>();
		try {
			aON.registrarAsistencia(asistencia);
			data.put("code","1");
			data.put("message", "ok");
			builder=Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("code","99");
			data.put("message", e.getMessage());
			builder=Response.status(Response.Status.BAD_REQUEST).entity(data);
		}
		return builder.build();
	}

}
