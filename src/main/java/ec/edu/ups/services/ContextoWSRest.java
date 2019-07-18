package ec.edu.ups.services;

import java.util.ArrayList;
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

import ec.edu.ups.fachadaNegocio.ListadoNombreDocente;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.on.DocenteON;

@Path("/MyRest")
@ApplicationPath("/resources")
public class ContextoWSRest extends Application {

	
	@Inject
	private DocenteON dON;

	//http://localhost:8080/Control-de-Asistencia/resources/MyRest/consultar?id=2
	@GET
	@Path("/consultar")
	@Produces("application/json")
	public Docente listaDocente(@QueryParam("id") int id) {
		return dON.getDocente(id);
	}
	
	@GET
	@Path("listado")
	@Produces("application/json")
	public List<Docente> getDocente(){
		List<Docente> listado = dON.getListaDocentes();
		return listado;
	}
	@GET
	@Path("listadoDocenteNombreApe")
	@Produces("application/json")
	public List<ListadoNombreDocente> getDocenteNombre(){
		List<ListadoNombreDocente>nombre=new ArrayList<>();
		List<Docente> listado = dON.getListaDocentes();
		for (Docente docente : listado) {
			nombre.add(new ListadoNombreDocente(docente.getNombres() ,docente.getApellidos()));
		}
		return nombre;
	}
	
	@POST
	@Path("/saveDocente")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertDocente(Docente dodente) {
		
		ResponseBuilder builder=null;
		Map<String, String>data=new HashMap<>();
		try {
			dON.guardar(dodente);
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
	@POST
	@Path("/saveDocenteRol")
	@Produces("application/json")
	@Consumes("application/json")
	public Response insertDocente(DocenteRol dr) {
		ResponseBuilder builder=null;
		Map<String, String>data=new HashMap<>();
		try {
			dON.guardarDocenteRol(dr);
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
