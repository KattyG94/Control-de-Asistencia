package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Opcion {
	@Id
	@GeneratedValue // (strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotEmpty
	private String opcion;

	@OneToOne
	@JoinColumn(name = "opcion_codigo")
	@JsonIgnore
	private Encuesta encuesta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	@Override
	public String toString() {
		return "Opcion [id=" + id + ", opcion=" + opcion + ", encuesta=" + encuesta + "]";
	}

}
