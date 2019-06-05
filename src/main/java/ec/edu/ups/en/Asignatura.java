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
	 * @return id Identificador unico
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo para el envio de un id de atributos
	 * @param id Valor del atributo
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo que permite retornar el codigo de asignatura
	 * @return Codigo unico de asignatura
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * Metodo de que permite enviar por parametro un codigo de tipo string
	 * @param codigo Codigo unico de asignatura
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * Metodo que permite retornar en nombre de la asignatura
	 * @return nombre de la asignatura
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que permite enviar por parametro el nombre de la asignatura de tipo texto
	 * @param Nombrede la asignatura
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo que permite retornar el numero de creditos de la asignatura
	 * @return Numero de creditos
	 */
	public int getCreditos() {
		return creditos;
	}
	/**
	 * Metodo que permite enviar el numero de creditos por parametros 
	 * @param creditos Numero de creditos
	 */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

}
