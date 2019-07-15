package ec.edu.ups.est.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ec.edu.ups.est.modelo.Carrera;
import ec.edu.ups.est.modelo.Matricula;
import ec.edu.ups.est.on.CarreraON;
import ec.edu.ups.est.on.MatriculaON;

@Path("/catser")
public class OperacionesService {

	@Inject
	private MatriculaON matriculaON;
	
	@Inject
	private CarreraON carreraON;
	
	@POST
	@Path("/insertarMatricula")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertMatricula(Matricula matricula) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			matriculaON.guardar(matricula);
			data.put("code", "100");
			data.put("message", "Datos registrados");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "101");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}

		return builder.build();
	}
	
	@GET
	@Path("/listaMatricula")
	@Produces("application/json")
	public List<Matricula> getMatricula() {
		return matriculaON.getListaMatriculas();
	}
	
	@POST
	@Path("/insertarCarrera")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertCarrera(Carrera carrera) {
		Response.ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			carreraON.guardar(carrera);
			data.put("code", "100");
			data.put("message", "Datos registrados");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "101");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(data);
		}

		return builder.build();
	}
	
	@GET
	@Path("/listaCarrera")
	@Produces("application/json")
	public List<Carrera> getCarreras() {
		return carreraON.getListaCarreras();
	}
	
}
