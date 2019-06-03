package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.List;

public class Matricula {
	private int id;
	private int numero;
	private String descripcion;
	private Estudiante estudiante;
	private List<Asignatura> listaAsignatura;
	private Carrera carrera;
	private Periodo periodo;
	
	public Matricula() {
		// TODO Auto-generated constructor stub
		listaAsignatura =new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

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
	public void setAsignatura(int id, String codigo, String nombre, String creditos) {
		this.listaAsignatura.add(new Asignatura(id, codigo, nombre, creditos));
		
	}
	
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
