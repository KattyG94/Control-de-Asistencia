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
import ec.edu.ups.fachadaNegocio.ListadoAlumnoNombreApellido;
import ec.edu.ups.fachadaNegocio.SoloGrupoAsignatura;
import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.modelo.Matricula;
import ec.edu.ups.modelo.Silabo;
import ec.edu.ups.on.AlumnoON;
import ec.edu.ups.on.AsingnaturaON;
import ec.edu.ups.on.GrupoON;
import ec.edu.ups.on.MatriculaON;
import ec.edu.ups.on.SilaboON;

@Path("/MyResult")
@ApplicationPath("/resources")
public class GrupoRest extends Application{
    @Inject
	private GrupoON grupoON;
    @Inject
    private AlumnoON lisaON;
    @Inject
    private AsingnaturaON asignaturaON;
    @Inject
    private MatriculaON matON;
	
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
			listaGrupoAsignatura.add(new SoloGrupoAsignatura(grupo.getId(),grupo.getNumero(), grupo.getAsignatura().getNombre(),grupo.getAsignatura().getId()));
			
		}
		return listaGrupoAsignatura;
	}
	@GET
	@Path("listadoGrupoAsignaturaByAlumnoId")
	@Produces("application/json")
	public List<SoloGrupoAsignatura> getGrupoAsignaturaAlumnoId(@QueryParam("id") int id){
		List<SoloGrupoAsignatura> listaGrupoAsignatura=new ArrayList<>();
		List<Grupo> listado = grupoON.getlistaGrupoAsignaturaAlumnoId(id);
		System.out.println(listado.size()+" Tamaño de lista");
		for (Grupo grupo : listado) {
			grupo.setCarrera(null);
			grupo.setDocente(null);
			grupo.setMatricula(null);
			grupo.setPeriodo(null);
			listaGrupoAsignatura.add(new SoloGrupoAsignatura(grupo.getId(),grupo.getNumero(), grupo.getAsignatura().getNombre(),grupo.getAsignatura().getId()));
			
		}
		return listaGrupoAsignatura;
	}
	@GET
	@Path("listadoAlumnoByIdGroupo")
	@Produces("application/json")
	public List<ListadoAlumnoNombreApellido> getAlumno(@QueryParam("id") int id){
		List<ListadoAlumnoNombreApellido> listadoAlumno=new ArrayList<>();
		List<Alumno> listado = lisaON.getListarAlumnosByGrupoId(id);
		for (Alumno alumno : listado) {
			List<Matricula>lista=alumno.getMatricula();
			for (Matricula matricula : lista) {
				alumno.setMatricula(null);
				listadoAlumno.add(new ListadoAlumnoNombreApellido(matricula.getCodigo(),alumno.getNombres(), alumno.getApellidos(),alumno.getId()));
				
			}
			
		}
		return listadoAlumno;
	}
	@GET
	@Path("listadoMatriculaById")
	@Produces("application/json")
	public List<Matricula> getMatricula(@QueryParam("id") int id){
//		List<ec.edu.ups.fachadaNegocio.Matricula> listaMat=new ArrayList<>();
		List<Matricula> lista=matON.getMatriculaId(id);
//		for (Matricula matricula : lista) {
//			listaMat.add(new ec.edu.ups.fachadaNegocio.Matricula(matricula.getCodigo(), matricula.getGrupo().getId(), matricula.getAlumno().getId()));;
//			matricula.setAlumno(null);
//			matricula.setAsistencia(null);
//			matricula.setGrupo(null);
//		}
		return lista;
	}
	@GET
	@Path("listadoSilaboByIdAsignatura")
	@Produces("application/json")
	public List<Silabo> getSilabo(@QueryParam("id") int id){
		List<Silabo> listadoAlumno=asignaturaON.listaSilaboByAsignaturId(id);
		System.out.println(listadoAlumno.size()+"Tamanio");
		return listadoAlumno;
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
