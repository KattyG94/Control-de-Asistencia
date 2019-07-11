package ec.ups.edu.asistencia.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.ups.edu.asistencia.bussiness.EstudianteBussiness;
import ec.ups.edu.asistencia.dao.EstudianteDAO;
import ec.ups.edu.asistencia.model.Estudiante;

@ManagedBean
@ViewScoped
public class EstudianteBean {
	
	@Inject
	private EstudianteBussiness eBussiness;
	
	@Inject
	private EstudianteDAO edao;
	
	@Inject
	private FacesContext facesContext;
	
	private Estudiante newEstudiante;
	
	private List<Estudiante> estudiantes;
	
	private boolean editing;
	
	private int id;
	
	@PostConstruct
	public void init() {
		newEstudiante= new Estudiante();
		editing=false;
		estudiantes=eBussiness.getListadoEstudiante();
	}
	
	public void loadData() {
		System.out.println("Load data" + id);
		if (id == 0)
			return;
		try {
			newEstudiante=eBussiness.getEst(id);
			editing=true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public Estudiante getNewEstudiante() {
		return newEstudiante;
	}

	public void setNewEstudiante(Estudiante newEstudiante) {
		this.newEstudiante = newEstudiante;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
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
			String cedula = newEstudiante.getCedula();
			if (eBussiness.validarCed(cedula) == true) {
				if (editing)
					eBussiness.actualizar(newEstudiante);
				else
					eBussiness.save(newEstudiante);
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
			eBussiness.eliminar(id);
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
	
	public String editar(Estudiante est) {
		editing = true;
		System.out.println(est);
		return "Estudiante?faces-redirect=true&id=" + est.getId();
	}
}
