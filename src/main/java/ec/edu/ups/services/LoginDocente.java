package ec.edu.ups.services;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.on.DocenteON;

@Path("/MyRest")
@ApplicationPath("/resources")
public class LoginDocente  extends Application{
	@Inject
	private DocenteON dON;
	
	@GET
	@Path("/loginDocente")
	@Produces("application/json")
	public Docente inisiarSesion(@QueryParam("usr") String usr,@QueryParam("passw") String passw) {
		Docente validar=null;
		try {
			validar=dON.docenteLogin(usr,passw);
			if(validar!=null) {
				//Docente logueado satisfactoriamente
			}
		} catch (Exception e) {
		
		}
		return validar;
		
	}
	@GET
	@Path("/loginDocente1")
	@Produces("application/json")
	public boolean inisiarSesion1(@QueryParam("usr") String usr,@QueryParam("passw") String passw) {
		boolean bandera=false;
		Docente docente=null;
		try {
			docente=dON.docenteLogin(usr,passw);
			System.out.println(docente.toString());
			if(docente.getRol().equals("Docente")) {
				bandera=true;
			}
		} catch (Exception e) {
			bandera =false;
		}
		return bandera;
		
	}
}