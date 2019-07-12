package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Matricula;
import ec.edu.ups.on.MatriculaON;

@ManagedBean
public class MatriculaControlador {

	private Matricula matricula = new Matricula();
	private List<Matricula> listaMatriculas;
	
	@Inject
	private MatriculaON matriculaON;
	
	private int id;
	
	@PostConstruct
	public void init() {
		matricula = new Matricula();
		listaMatriculas = matriculaON.getListaMatriculas();
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getListaMatriculas() {
		return listaMatriculas;
	}

	public void setListaMatriculas(List<Matricula> listaMatriculas) {
		this.listaMatriculas = listaMatriculas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void loadData() {
		if(id==0) {
			return;
		}else {
			matricula = matriculaON.getMatricula(id);
		}
	}
	
	public void mostrarData(int ids) {
		if(ids==0) {
			return;
		}else {
			matricula=matriculaON.getMatricula(ids);
		}
	}
	
	public String cargarDatos() {
		try {
			matriculaON.guardar(matricula);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String editar(int id) {
		return "Matriculas?faces-redirect=true&id="+id;
	}
	
	public String borrar(int id) {
		try {
			matriculaON.borrar(id);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public String listadoMatriculas() {
		return "ListarMatricula";
	}
	
	public String nuevo() {
		matricula = new Matricula();
		return "Matriculas";
	}
}
