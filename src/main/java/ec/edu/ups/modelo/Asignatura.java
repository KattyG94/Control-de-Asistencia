package ec.edu.ups.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Asignatura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private int num_creditos;
//	
//	@ManyToMany(cascade = {CascadeType.ALL},mappedBy = "asignaturas")
//    private Set<Grupo> grupos=new HashSet<>();
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
//	public Set<Grupo> getGrupos() {
//		return grupos;
//	}
//	public void setGrupos(Set<Grupo> grupos) {
//		this.grupos = grupos;
//	}
	@Override
	public String toString() {
		return "Asignatura [id=" + id + ", nombre=" + nombre + ", num_creditos=" + num_creditos 
				+ ", periodo=" + periodo + "]";
	}

	
	

}
