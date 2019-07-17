package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import DAO.AlumnoDAO;
import bussiness.AlumnoBussiness;
import modelos.Alumno;

@ManagedBean
@ViewScoped
public class AlumnoBean {

	@Inject
	private AlumnoBussiness aBussiness;
	
	@Inject
	private AlumnoDAO adao;
	
	@Inject
	private FacesContext facesContext;
	
	private Alumno newAlumno;
	
	private List<Alumno> alumnos;
	
	private boolean editing;
	
	private int id;
	
	@PostConstruct
	public void init() {
		newAlumno= new Alumno();
		editing=false;
		alumnos=aBussiness.getListadoAlumno();
	}
	
	public void loadData() {
		System.out.println("Load data" + id);
		if (id == 0)
			return;
		try {
			newAlumno=aBussiness.getAlum(id);
			editing=true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public Alumno getNewAlumno() {
		return newAlumno;
	}

	public void setNewAlumno(Alumno newAlumno) {
		this.newAlumno = newAlumno;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setEstudiantes(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public boolean isEditing() {
		return editing;
	}

	public void setEditing(boolean editing) {
		this.editing = editing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String guardar() {
		System.out.println("Editando "+ editing);
		try {
			String cedula = newAlumno.getCedula();
			if (aBussiness.validarCed(cedula) == true) {
				if (editing)
					aBussiness.actualizar(newAlumno);
				else
					aBussiness.save(newAlumno);
				System.out.println("Registro Guardado");
				return "ListadoEstudiantes?faces-redirect=true";
			} else
				return "Error";
		}catch (Exception e) {
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}
	public String eliminar(int id) {
		try {
			aBussiness.eliminar(id);
			System.out.println("Registro eliminado");
			return "ListadoEstudiantes?faces-redirect=true";
		} catch (Exception e) {
			System.out.println("Error al Eliminar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}
	public String editar(Alumno est) {
		editing = true;
		System.out.println(est);
		return "Estudiante?faces-redirect=true&id=" + est.getId();
	}
	
}
