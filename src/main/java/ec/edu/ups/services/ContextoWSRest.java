package ec.edu.ups.services;

import java.util.HashMap;
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

import ec.edu.ups.dao.DocenteDAO;
import ec.edu.ups.modelo.Docente;

@Path("/MyRest")
@ApplicationPath("/resources")
public class ContextoWSRest extends Application {
//http://localhost:8080/Control-de-Asistencia/resources/MyRest/hola

	@Inject
	private DocenteDAO dao;

	@GET
	@Path("/hola")
	public String getMesage() {
		return "Hola Mundo";

	}

	//http://localhost:8080/Control-de-Asistencia/resources/MyRest/consultar?id=2
	@GET
	@Path("/consultar")
	@Produces("application/json")
	public Docente listaDocente(@QueryParam("id") int id) {
		return dao.read(id);
	}
	
	//http://localhost:8080/Control-de-Asistencia/resources/MyRest/registrar?apellido="Perez"&nombre="Mariela"&cedula="1900790682"&direccion="Quito"&idProfesion=1
	@GET
	@Path("/registrar")
	@Produces("application/json")
	public void registrar(@QueryParam("apellido")String  apellido,@QueryParam("nombre")String  nombre,@QueryParam("cedula")String  cedula
			,@QueryParam("direccion")String  direccion,@QueryParam("idProfesion")int  idProfesion) {
		Docente d=new Docente();
		d.setNombre(nombre);
		d.setApellido(apellido);
		d.setCedula(cedula);
		d.setDireccion(direccion);
		System.out.println(d.toString());
		dao.create(d);
	}
	//http://localhost:8080/Control-de-Asistencia/resources/MyRest/insertar
	@POST
	@Path("/insertar")
	@Produces("application/json")
	@Consumes("application/json")
	public void create(Docente d) {
		Response.ResponseBuilder builder=null;
		Map<String, String>data=new HashMap<>();
		dao.create(d);
		data.put("code", "1111");
		data.put("message", "Hecho");
		builder=Response.status(Response.Status.OK).entity(data);
	}

}
