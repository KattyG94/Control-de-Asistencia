package ec.edu.ups.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Grupo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
    private int numero;
	@Transient
	private int docenteIdTemp;
	@Transient
	private String cedula;
	@OneToOne
	@JoinColumn(name="docente_codigo")
	private Docente docente;
	
	@ManyToOne
	@JoinColumn(name = "carrera_codigo")
	private Carrera carrera;
	
	@ManyToOne
	@JoinColumn(name = "asignatura_codigo")
	private Asignatura asignatura;
	
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
	public int getDocenteIdTemp() {
		return docenteIdTemp;
	}
	public void setDocenteIdTemp(int docenteIdTemp) {
		this.docenteIdTemp = docenteIdTemp;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", numero=" + numero + ", docenteIdTemp=" + docenteIdTemp + ", cedula=" + cedula
				+ ", docente=" + docente + ", carrera=" + carrera + ", asignatura=" + asignatura + "]";
	}
	

}
