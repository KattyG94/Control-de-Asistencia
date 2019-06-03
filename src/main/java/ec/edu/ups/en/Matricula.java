package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Matricula que contiene 7 atributos con sus respectivos metodos get y
 * set Esta clase facilita la interaccion de la matricula
 * 
 * @author angel
 *
 */
public class Matricula {
	private int id;
	private int numero;
	private String descripcion;
	private Estudiante estudiante;
	private List<Asignatura> listaAsignatura;
	private Carrera carrera;
	private Periodo periodo;

	/**
	 * Metodo constructor de la clase Matricula
	 */
	public Matricula() {

		listaAsignatura = new ArrayList<>();
	}

	/**
	 * Metodo que permite retornar el identificador de la asignatura
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Metodo que permite enviar por parametro el identificador de la Matricula
	 * 
	 * @param id codigo identificador de matricula
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo que permite retornar el numero de Matricula
	 * 
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Metodo que contiene un parametro
	 * 
	 * @param numero de tipo entero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * Matodo asignatura que permite enviar una lista de asignatura
	 * 
	 * @param id       Itentificador de asignatura
	 * @param codigo   Codigo unico de la asignatura
	 * @param nombre   Nombre de la asignatura
	 * @param creditos Numero de creditos de la Asignatura
	 */
	public void setAsignatura(int id, String codigo, String nombre, int creditos) {
		this.listaAsignatura.add(new Asignatura(id, codigo, nombre, creditos));

	}

	/**
	 * Metodo que permite retornar una lista de asignatira
	 * 
	 * @return
	 */
	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
