package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Carrera {

	@Id
	@Column(name = "carrera_codigo")
	private int id;

	@NotNull
	@Column(name = "carrera_nombre")
	private String nombre;

	@NotNull
	@Column(name = "carrera_descripcion")
	private String descripcion;

	@NotNull
	@Column(name = "carrera_numero_ciclos")
	private int numCiclos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "carrera_matricula")
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

	@Override
	public String toString() {
		return "Carrera [codigo=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", numCiclos="
				+ numCiclos + ", matriculas=" + matriculas + "]";
	}

	public void addMatricula(Matricula matricula) {
		if(matriculas==null) {
			matriculas=new ArrayList<>();
		}else {
			this.matriculas.add(matricula);
		}
	}

}
