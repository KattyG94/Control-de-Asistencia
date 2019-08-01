package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.on.AlumnoON;

@ManagedBean
@ViewScoped
public class AlunmoControlador {
 
	private Alumno alumno;
	private List<Alumno> listaAlumnos;

	@Inject
	private AlumnoON alON;

	private int id;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		alumno = new Alumno();
		listaAlumnos = alON.getAlumnos();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			alumno = alON.getAlumno(id);
		}
	}

	public void mostrarData(int ida) {
		if (ida == 0) {
			return;
		} else {
			alumno = alON.getAlumno(ida);
		}
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String cargarDatos() {
		try {
			alON.guardar(alumno);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String editar(int id) {
		return "Alumnos?faces-redirect=true&id=" + id;
	}

	public String borrar(int codigo) {
		try {
			alON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String nuevo() {
		alumno = new Alumno();
		return null;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

}
