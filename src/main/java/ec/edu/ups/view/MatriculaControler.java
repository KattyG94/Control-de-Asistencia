package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.modelo.Matricula;
import ec.edu.ups.on.AlumnoON;
import ec.edu.ups.on.GrupoON;
import ec.edu.ups.on.MatriculaON;

@ManagedBean
@ViewScoped
public class MatriculaControler {
	private int id;
	private Grupo grupo;
	private Alumno alumno;
	private Matricula matricula;
	private List<Grupo> grupos;
	private List<Alumno> alumnos;
	private List<Matricula> listaMatriculas;
	
	@Inject
	private GrupoON grupoON;
	@Inject
	private AlumnoON alumnoON;
	@Inject
	private MatriculaON matriculaON;
	
	@Inject
	private FacesContext fc;
	@PostConstruct
	public void init() {
		matricula=new Matricula();
		grupo=new Grupo();
		alumno =new Alumno();
		
		
		grupos=grupoON.getGrupos();
		alumnos=alumnoON.getAlumnos();
//		listaMatriculas=matriculaON.getMatriculas();
		
	}
	public void loadData() {
		if (id == 0)
			return;
		matricula=matriculaON.getMatricula(id);
	}
	public String registrarMatricula() {
		try {
			matricula.setAlumno(alumno);
			matricula.setGrupo(grupo);
			matriculaON.guardarMatricula(matricula);
			init();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}
		return null;
	}
	public String editar(int id) {
		return "Matriculas?faces-redirect=true&id=" + id;
	}

	public void nuevo() {
		matricula=new Matricula();
	}

	public String borrar(int codigo) {
		try {
			matriculaON.eliminarMatricula(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void elegirAlumno() {
		try {
			alumno = alumnoON.getAlumno(alumno.getId());
			System.out.println(alumno.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
	public void getAlumnoCedula() {
		try {
			alumno=alumnoON.getAlumnoCedula(alumno);
			System.out.println(alumno.toString());
		} catch (Exception e) {
			throw e;
		}
	}
	public void elegirGrupo() {
		try {
			System.out.println(grupo.toString());
			grupo = grupoON.getGrupo(grupo);
			System.out.println("Hola amigos ");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public MatriculaON getMatriculaON() {
		return matriculaON;
	}
	public void setMatriculaON(MatriculaON matriculaON) {
		this.matriculaON = matriculaON;
	}
	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}
	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}
	
}
