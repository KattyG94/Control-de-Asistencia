package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.on.DocenteON;

@ManagedBean
public class DocenteControlador {

	private Docente docente=new Docente();
	private List<Docente> listaDocente;
	
	@Inject
	private DocenteON dON;

	@PostConstruct
	public void init() {
		 docente=new Docente();
		listaDocente=dON.getListaDocentes();
	}
	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
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
			// TODO: handle exception
		}
		return null;
	}

	public String editar(int id) {
		docente=dON.getDocente(id);
		System.out.println(docente.toString());
		return "Docentes";
	}
	public String borrar(int codigo) {
		try {
			dON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
