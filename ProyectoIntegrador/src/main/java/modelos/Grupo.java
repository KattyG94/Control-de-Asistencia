package modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "docente_codigo")
	private Docente docente;
	@ManyToMany(mappedBy ="grupos" ,cascade = CascadeType.ALL)
	private List<Alumno> alumnos;
	private int numero;
	@ManyToOne
	@JoinColumn(name = "asignatura_codigo")
	private Asignatura asignatura;
	@ManyToOne
	@JoinColumn(name = "carrera_codigo")
	private Carrera carrera;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public List<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", docente=" + docente + ", alumnos=" + alumnos + ", numero=" + numero
				+ ", asignatura=" + asignatura + ", carrera=" + carrera + "]";
	}
	
	

}
