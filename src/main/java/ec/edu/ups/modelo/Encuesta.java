package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String pregunta;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "opcion_codigo")
	private List<Opcion> opciones;

	@ManyToOne
	@JoinColumn(name = "grupo_codigo")
	private Grupo grupo_encuesta;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "resultado_codigo")
	private List<Resultado_Encuesta> resultados;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public Grupo getGrupo_encuesta() {
		return grupo_encuesta;
	}

	public void setGrupo_encuesta(Grupo grupo_encuesta) {
		this.grupo_encuesta = grupo_encuesta;
	}

	public List<Resultado_Encuesta> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado_Encuesta> resultados) {
		this.resultados = resultados;
	}

	public void addOpciones(Opcion opcion) {
		if (opciones == null) {
			opciones = new ArrayList<Opcion>();
		} else {
			this.opciones.add(opcion);
		}
	}

	@Override
	public String toString() {
		return "Encuesta [id=" + id + ", pregunta=" + pregunta + ", opciones=" + opciones + ", grupo_encuesta="
				+ grupo_encuesta + ", resultados=" + resultados + "]";
	}

}
