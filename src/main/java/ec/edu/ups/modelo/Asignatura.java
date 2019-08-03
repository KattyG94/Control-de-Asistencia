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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int num_creditos;

	@OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Grupo> grupos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="asig_codigo")
	private List<Silabo> silabos;
	@ManyToOne
	@JoinColumn(name = "periodo_codigo")
	private Periodo periodo;
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
	public int getNum_creditos() {
		return num_creditos;
	}
	public void setNum_creditos(int num_creditos) {
		this.num_creditos = num_creditos;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
	public List<Silabo> getSilabos() {
		return silabos;
	}
	public void setSilabos(List<Silabo> silabos) {
		this.silabos = silabos;
	}
	public void addSilabos(Silabo silabo) {
		if(silabos==null) {
			silabos=new ArrayList<>();
			
		}
		this.silabos.add(silabo);
	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", num_creditos=" + num_creditos + ", grupos=" + grupos
				+ ", silabos=" + silabos + ", periodo=" + periodo + "]";
	}


	
	
	

}
