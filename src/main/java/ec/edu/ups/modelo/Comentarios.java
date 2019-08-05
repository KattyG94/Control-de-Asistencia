package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Comentarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "codigo_matricula")
	private Matricula matriculaC;
	private String comentario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Matricula getMatriculaC() {
		return matriculaC;
	}
	public void setMatriculaC(Matricula matriculaC) {
		this.matriculaC = matriculaC;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	@Override
	public String toString() {
		return "Comentarios [id=" + id + ", matriculaC=" + matriculaC + ", comentario=" + comentario + "]";
	}
	
	

}
