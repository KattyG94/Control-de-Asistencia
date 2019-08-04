package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Silabo;
import ec.edu.ups.on.AsingnaturaON;


@ManagedBean
@ViewScoped
public class AsignaturaControler {
private Asignatura asignatura;
	
	private int id;
	
	private List<Asignatura>listaAsignatura;
	@Inject
	private AsingnaturaON asignaturaON;
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		asignatura=new Asignatura();
		asignatura.addSilabos(new Silabo());
		listaAsignatura=asignaturaON.getAsignatura();
		
		
	}
	public void loadData() {
		if (id == 0)
			return;
		asignatura = asignaturaON.getAsignatura(id);
		asignatura.getSilabos().size();
		System.out.println(asignatura.getNombre() );
		System.out.println(asignatura.getSilabos().size());
		for (Silabo t : asignatura.getSilabos()) {
			System.out.println("\t"+t);
		}
	}
	public String registrarAsignatura() {
		try {
			asignaturaON.guardarAsignatura(asignatura);
			init();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}
		return null;
	}
	public String editar(int id) {
		return "Asignaturas?faces-redirect=true&id=" + id;
	}
	
	public void nuevo() {
		asignatura  =new Asignatura();
	}
	public String borrar(int codigo) {
		try {
			asignaturaON.eliminarAsignatura(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	public void addSilabos() {
		asignatura.addSilabos(new Silabo());
	}
	
	
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}
	public void setListaPeriodos(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
