package ec.edu.ups.services;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import ec.edu.ups.on.AlumnoON;

@Path("/MyLogin")
@ApplicationPath("/resources")
public class LoginEstudiante extends Application{
	@Inject
	private AlumnoON aON;
	
	@GET
	@Path("/loginAlumno")
	@Produces("application/json")
	public boolean inisiarSesion1(@QueryParam("usr") String usr,@QueryParam("passw") String passw) {
		boolean bandera=false;
		try {
			if(aON.alumnoLogin(usr,passw)!=null) {
				bandera=true;
			}
		} catch (Exception e) {
			Respuesta r = new Respuesta();
			r.setCodigo(99);
			r.setMensaje(e.getMessage());
		}
		return bandera;
		
	}

}
