package ec.edu.ups.modelo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Alumno extends Usuario {
	@JoinTable(name = "rel_grup_alum", joinColumns = @JoinColumn(name = "FK_GRUPO", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_ALUMNO", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "alumno_codigo")
	private List<Grupo> grupos;

	public List<Grupo> getGrupos() {
		return grupos;
	}
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return "Alumno [grupos=" + grupos + "]";
	}
	
	
	

}
