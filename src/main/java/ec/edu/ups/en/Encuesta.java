package ec.edu.ups.en;

/**
 * Clase encuesta con 4 atributos y sus respectivos metodos de manipulacion de
 * datos get y set Esta clase permite manipular los datos de la encuesta que los
 * estudiantes, docentes y los administradores realicen
 * 
 * @author angel
 *
 */
public class Encuesta {
	private int id;
	private String concepto;
	private String descripcion;
	private Grupo grupo;

	/**
	 * Metodo constructor sin maparametros de la clase encuesta
	 */
	public Encuesta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Metodo constructor con parametros de la clase Encuesta
	 * @param id Codigo identificador de la encuesta 
	 * @param concepto Tema sobre la encueta planteada
	 * @param descripcion Descripcion general de de la encuesta
	 * @param grupo Objeto de tipo grupo
	 */
	public Encuesta(int id, String concepto, String descripcion, Grupo grupo) {
		this.id = id;
		this.concepto = concepto;
		this.descripcion = descripcion;
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
