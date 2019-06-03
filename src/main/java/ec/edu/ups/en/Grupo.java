package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
	private int id;
	private String codigo;
	private String numero;
	private String descripcion;
	private List<Docente> listaDocentes;
	private Matricula matricula;
	
	public Grupo() {
		// TODO Auto-generated constructor stub
		listaDocentes = new ArrayList<>();
	}
	

	public Grupo(int id, String codigo, String numero, String descripcion,Matricula matricula) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.numero = numero;
		this.descripcion = descripcion;
		this.matricula = matricula;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Docente> getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(Docente docentes) {
		this.listaDocentes.add(docentes);
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
