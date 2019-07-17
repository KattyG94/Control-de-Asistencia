package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Asistencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "silabo_codigo")
	private List<Silabo> silabos;
	@OneToOne
	@JoinColumn(name="grupo_codigo")
	private Grupo grupo;
	private String fecha;
	private String estado;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Silabo> getSilabos() {
		return silabos;
	}
	public void setSilabos(List<Silabo> silabos) {
		this.silabos = silabos;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Asistencia [id=" + id + ", silabos=" + silabos + ", grupo=" + grupo + ", fecha=" + fecha + ", estado="
				+ estado + "]";
	}
	
	
	

}
