package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Encuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "codigo_matricula")
	private Matricula matriculaE;
	private String encuesta;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEncuesta() {
		return encuesta;
	}
	public void setEncuesta(String encuesta) {
		this.encuesta = encuesta;
	}
	public Matricula getMatriculaE() {
		return matriculaE;
	}
	public void setMatriculaE(Matricula matriculaE) {
		this.matriculaE = matriculaE;
	}
	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", matriculaE=" + matriculaE + ", encuesta=" + encuesta + "]";
	}
	
	
}
