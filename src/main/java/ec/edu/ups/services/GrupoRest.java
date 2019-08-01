package ec.edu.ups.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import ec.edu.ups.fachadaNegocio.ListaSoloAsignatura;
import ec.edu.ups.fachadaNegocio.SoloGrupoAsignatura;
import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.on.GrupoON;

@Path("/MyResult")
@ApplicationPath("/resources")
public class GrupoRest extends Application{
    @Inject
	private GrupoON grupoON;
	
	@GET
	@Path("listadoCarreraByDocenteId")
	@Produces("application/json")
	public List<ListaSoloAsignatura> getGrupito(@QueryParam("id") int id){
		List<Asignatura> listado = grupoON.getGruposAsignatura(id);
		List<ListaSoloAsignatura> listita=new ArrayList<>();
		for (Asignatura asignatura : listado) {
			listita.add(new ListaSoloAsignatura(asignatura.getNombre()));
		}
		return listita;
	}
	@GET
	@Path("listadoGrupoAsignaturaByDocenteId")
	@Produces("application/json")
	public List<SoloGrupoAsignatura> getGrupoAsignatura(@QueryParam("id") int id){
		List<SoloGrupoAsignatura> listaGrupoAsignatura=new ArrayList<>();
		List<Grupo> listado = grupoON.getlistaGrupoAsignatura(id);
		for (Grupo grupo : listado) {
			grupo.setCarrera(null);
			grupo.setDocente(null);
			grupo.setMatricula(null);
			grupo.setPeriodo(null);
			listaGrupoAsignatura.add(new SoloGrupoAsignatura(grupo.getId(),grupo.getNumero(), grupo.getAsignatura().getNombre()));
			
		}
		return listaGrupoAsignatura;
	}
    
    
	@GET
	@Path("listadoGrupo")
	@Produces("application/json")
	public List<Grupo> getGrupo(@QueryParam("id") int id){
		List<Grupo> listado=null;
		try {
		      listado = grupoON.getGruposIdDocente(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return listado;
	}
//	@GET
//	@Path("listadoMaterias")
//	@Produces("application/json")
//	public List<Grupo> getGrupoAsignatura(@QueryParam("id") int id){
//		List<Grupo> listado=null;
//		try {
//		      listado = grupoON.getGruposAsignatura(id);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return listado;
//	}
}
