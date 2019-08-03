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
public class Silabo {

	@Id
	@GeneratedValue//(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@NotEmpty
	private String descripcion;
	
	@OneToOne
	@JoinColumn(name="asig_codigo")
	@JsonIgnore
	private Asignatura asignatura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	@Override
	public String toString() {
		return "Silabo [id=" + id + ", descripcion=" + descripcion + ", asignatura=" + asignatura + "]";
	}

	

}
