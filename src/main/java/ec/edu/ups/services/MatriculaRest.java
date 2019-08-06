package ec.edu.ups.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Matricula;
import ec.edu.ups.on.MatriculaON;
@Path("/MyResult")
@ApplicationPath("/resources")
public class MatriculaRest  extends Application{

	@Inject
	private MatriculaON mON;
	
//	@GET
//	@Path("listadoMatricula")
//	@Produces("application/json")
//	public List<Matricula>getMatriculas(@QueryParam("id")int id){
//		List<Matricula> listaMatricula=mON.getMatriculas(id);
//		System.out.println(listaMatricula.size()  +"Numero de lis");
//		
//		return listaMatricula;
//		
//	}
	
}
