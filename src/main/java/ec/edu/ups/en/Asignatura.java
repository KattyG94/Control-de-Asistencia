package ec.edu.ups.en;
/**
 * Clase asignatura que contine 4 atributos 
 * Contine los atributos de la asignatura y sus respectivos metodos get y set 
 * @author angel
 *
 */
public class Asignatura {
	private int id;
	private String codigo;
	private String nombre;
	private int creditos;

	/**
	 * Metodo constructor
	 */
	public Asignatura() {
		
	}
	/**
	 * Metodo constructor con parametros
	 * @param id Identificador de asignatura
	 * @param codigo codigo de asinatura unico correspondiente a la asignatura de Alfanumerico
	 * @param nombre nombre de la asignatura
	 * @param creditos numero de creditos
	 */
	public Asignatura(int id, String codigo, String nombre, int creditos) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	/**
	 * Metodo que permite retornar el identificador de la asignatura
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo para el envio de un id de atributos
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo que permite retornar el codigo de asignatura
	 * @return
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * Metodo de que permite enviar por parametro un codigo de tipo string
	 * @param codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Metodo que permite retornar en nombre de la asignatura
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que permite enviar por parametro el nombre de la asignatura de tipo texto
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que permite retornar el numero de creditos de la asignatura
	 * @return
	 */
	public int getCreditos() {
		return creditos;
	}
	/**
	 * Metodo que permite enviar el numero de creditos por parametros 
	 * @param creditos
	 */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

}
