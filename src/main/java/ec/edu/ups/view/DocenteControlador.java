package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.on.DocenteON;

@ManagedBean
public class DocenteControlador {

	private Docente docente = new Docente();
	private List<Docente> listaDocente;

	@Inject
	private DocenteON dON;

	private int id;

	@PostConstruct
	public void init() {
		docente = new Docente();
		listaDocente = dON.getListaDocentes();
	}

	public void loadData() {
		System.out.println("codigo editar " + id);
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

	public List<Docente> getListaDocente() {
		return listaDocente;
	}

	public void setListaDocente(List<Docente> listaDocente) {
		this.listaDocente = listaDocente;
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
		System.out.println("dddd  "+ id);
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
}
