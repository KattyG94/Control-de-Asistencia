package ec.edu.ups.services.soa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import ec.edu.ups.fachadaNegocio.ListadoNombreDocente;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.on.DocenteON;

@WebService
public class ContextoWSRSoa {
	
	@Inject
	private DocenteON dON;
	
	@WebMethod
	public Docente listaDocente(int id) {
		return dON.getDocente(id);
	}
//	@WebMethod
//	public List<ListadoNombreDocente> getDocenteNombre(){
//		List<ListadoNombreDocente>nombre=new ArrayList<>();
//		List<Docente> listado = dON.getListaDocentes();
//		for (Docente docente : listado) {
//			nombre.add(new ListadoNombreDocente(docente.getNombres(),docente.getApellidos()));
//		}
//		return nombre;
//	}
	@WebMethod
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
	@WebMethod
	public int  sumar(int a, int b) {
		return a+b;
		
	}

}
