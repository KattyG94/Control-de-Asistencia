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
	public Docente loginDocente(@QueryParam("correo") String correo,@QueryParam("contrasena") String contrasena) {
		Docente validar=null;
		try {
			validar=dON.docenteLogin(correo,contrasena);
			if(validar!=null) {
				//Docente logueado satisfactoriamente
			}
		} catch (Exception e) {
		
		}
		return validar;
		
	}

		
	
}