package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.dao.AsignaturaDAO;
import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.on.AsignaturaON;


@ManagedBean
@ViewScoped
public class AsignaturaBean {

	@Inject
	private AsignaturaON aBussiness;
	
	@Inject
	private AsignaturaDAO adao;
	
	@Inject
	private FacesContext facesContext;
	

	private Asignatura newAsignatura;
	
	private List<Asignatura> asignatura;
	
	private boolean editing;
	
	private int id;

	@PostConstruct
	public void init() {
		newAsignatura= new Asignatura();
		editing=false;
		asignatura=aBussiness.getListadoAsignatura();
	}
	
	public void loadData() {
		System.out.println("Load data" + id);
		if (id==0)
			return;
		try {
			newAsignatura=aBussiness.getAsig(id);
			editing=true;
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
	}

	public Asignatura getNewAsignatura() {
		return newAsignatura;
	}

	public void setNewAsignatura(Asignatura newAsignatura) {
		this.newAsignatura = newAsignatura;
	}

	public List<Asignatura> getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(List<Asignatura> asignatura) {
		this.asignatura = asignatura;
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
			int codigo = newAsignatura.getCodigo();
				if (editing)
					aBussiness.actualizar(newAsignatura);
				else
					aBussiness.save(newAsignatura);
				System.out.println("Registro Guardado");
				return "ListadoAsignatura?faces-redirect=true";
			
		}catch (Exception e) {
			System.out.println("Error al guardar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}
	
	public String eliminar(int codigo) {
		try {
			aBussiness.eliminar(codigo);
			System.out.println("Registro eliminado");
			return "ListadoAsignatura?faces-redirect=true";
		} catch (Exception e) {
			System.out.println("Error al Eliminar");
			e.printStackTrace();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Error");
			facesContext.addMessage(null, m);
		}
		return null;
	}
	
	public String editar(Asignatura asig) {
		editing = true;
		System.out.println(asig);
		return "Asignatura?faces-redirect=true&id=" + asig.getCodigo();
	}
}
