package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.on.DocenteON;

@ManagedBean
@ViewScoped
public class DocenteControlador {

	private Docente docente = new Docente();
	private List<Docente> listaDocente;

	@Inject
	private DocenteON dON;

	private int id;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		setListaDocente(dON.getListaDocentes());
	}

	public void loadData() {
		if (id == 0)
			return;
		docente = dON.getDocente(id);
		System.out.println("Estoy aqui");
		System.out.println(docente.toString());
	}

	public void mostrarData(int ids) {
		System.out.println("codigo editar " + ids);
		if (ids == 0)
			return;
		docente = dON.getDocente(ids);
		System.out.println("Estoy aqui");
		System.out.println(docente.toString());
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}

	public String cargarDatos() {
		try {
			dON.guardar(docente);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String editar(int id) {
		System.out.println("dddd  " + id);
		return "Docentes?faces-redirect=true&id=" + id;
	}

	public String borrar(int codigo) {
		try {
			dON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String listadoDocentes() {
		System.out.println("Hola");
		return "ListarDocente";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String nuevo() {
		docente = new Docente();
		return "Docentes";
	}

	public String buscarRol(DocenteRol drol) {
		System.out.println("buscando Rol " + drol);
		try {
			Rol rol = dON.getRol(drol.getCodigoTemRol());
			drol.setRol(rol);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}

		return null;
	}

	public String addRol() {
		System.out.println("jav");
		docente.addDocenteRol(new DocenteRol());
		System.out.println("size 2: " + docente.getRoles().size());
		return null;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
	}
}
