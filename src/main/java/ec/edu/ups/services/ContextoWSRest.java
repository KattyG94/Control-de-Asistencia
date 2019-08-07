package ec.edu.ups.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.on.AlumnoON;
import ec.edu.ups.on.DocenteON;

@Path("/MyRest")
@ApplicationPath("/resources")
public class ContextoWSRest extends Application {

	@Inject
	private AlumnoON aON;
	@Inject
	private DocenteON dON;

	@GET
	@Path("/loginAlumno")
	@Produces("application/json")
	public Alumno inisiarSesion(@QueryParam("correo") String correo, @QueryParam("contrasena") String contrasena) {
		Alumno validar = null;
		try {
			validar = aON.alumnoLogin(correo, contrasena);
			if (validar != null) {

			}
		} catch (Exception e) {

		}
		return validar;

	}

	@GET
	@Path("/loginDocente")
	@Produces("application/json")
	public Docente loginDocente(@QueryParam("correo") String correo, @QueryParam("contrasena") String contrasena) {
		Docente validar = null;
		try {
			validar = dON.docenteLogin(correo, contrasena);
			if (validar != null) {
				// Docente logueado satisfactoriamente
			}
		} catch (Exception e) {

		}
		return validar;

	}

	@GET
	@Path("/consultar")
	@Produces("application/json")
	public Docente listaDocente(@QueryParam("id") int id) {
		return dON.getDocente(id);
	}

	

	@GET
	@Path("actualizarUbicacionAlumno")
	@Produces("application/json")
	public void actualizarUbicacionAlumno(@QueryParam("id") int id, @QueryParam("latitud") double latitud,
			@QueryParam("longitud") double longitud) {

		aON.actualizarUbicacionAlumno(id, latitud, longitud);

	}


	@POST
	@Path("/saveDocente")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertDocente(Docente dodente) {

		ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			dON.guardar(dodente);
			data.put("code", "1");
			data.put("message", "ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}

	@POST
	@Path("/saveDocenteRol")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertDocente(DocenteRol dr) {
		ResponseBuilder builder = null;
		Map<String, String> data = new HashMap<>();
		try {
			dON.guardarDocenteRol(dr);
			data.put("code", "1");
			data.put("message", "ok");
			builder = Response.status(Response.Status.OK).entity(data);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		return builder.build();
	}

}

