package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Column(name = "descripcion")
	private String descripcion;

	@NotNull
	@Column(name = "numCiclos")
	private int numCiclos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_codigo")
	private List<Matricula> matriculas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumCiclos() {
		return numCiclos;
	}

	public void setNumCiclos(int numCiclos) {
		this.numCiclos = numCiclos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public void addMatriculas(Matricula matricula) {
		if (matriculas == null) {
			matriculas = new ArrayList<>();
		}
		this.matriculas.add(matricula);
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", numCiclos=" + numCiclos
				+ ", matriculas=" + matriculas + "]";
	}

}
