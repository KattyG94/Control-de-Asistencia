package ec.ups.edu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import ec.ups.edu.asistencia.bussiness.EstudianteBussiness;
import ec.ups.edu.asistencia.model.Estudiante;

@Path("/estudiante")
public class EstudianteServiceRest {

	@Inject
	private EstudianteBussiness eBussiness;
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Estudiante> getEstudiantes(){
		return eBussiness.getListadoEstudiante();
	}
	
	@POST
	@Path("/save")
	@Consumes("application/json")
	@Produces("application/json")
	public Response insertEst(Estudiante estudiante) {
		ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		
		try {
			eBussiness.save(estudiante);
			data.put("code", "1");
			data.put("message", "ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}
	
	@POST
	@Path("/update")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateEst(Estudiante estudiante) {
		ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			eBussiness.actualizar(estudiante);
			data.put("code", "1");
			data.put("message", "ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}
	
	@DELETE
	@Path("/delete")
	@Consumes("application/json")
	@Produces("application/json")
	public Response borrarEst(@QueryParam("id")int id) {
		ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		
		try {
			eBussiness.eliminar(id);
			data.put("code", "1");
			data.put("message", "ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}	
	
	@GET
	@Path("/buscar")
	@Produces("application/json")
	public Estudiante buscar(@QueryParam("id")int id) {
		return eBussiness.buscar(id);
	}
}
