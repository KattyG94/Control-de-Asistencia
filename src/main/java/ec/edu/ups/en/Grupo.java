package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Grupo que contiene 6 atributos y sus respectivos metodos get y set
 *
 * @author angel
 *
 */
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

	/**
	 * Mtodo constructor con parametros
	 * 
	 * @param id          Identificador unico del grupo
	 * @param codigo      Valor unico de que permite diferenciar con un codigo unico
	 * @param numero      Numero de grupo
	 * @param descripcion Descripcion general del proyecto
	 * @param matricula   Objeto de tipo matricula
	 */

	public Grupo(int id, String codigo, String numero, String descripcion, Matricula matricula) {
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
