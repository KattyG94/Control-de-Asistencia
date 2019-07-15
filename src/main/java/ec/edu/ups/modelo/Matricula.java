package ec.edu.ups.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matricula {

	@Id
	@Column(name = "matricula_codigo")
	private int id;

	@OneToOne
	@JoinColumn(name = "carrera_matricula")
	@JsonIgnore
	private Matricula matricula;

	public int getId() {
		return id;
	}

	public void setId(int codigo) {
		this.id = codigo;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Matricula [codigo=" + id + ", matricula=" + matricula + "]";
	}

}
