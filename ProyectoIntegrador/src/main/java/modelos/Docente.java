package modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Docente extends Usuario {

	@OneToMany(mappedBy = "docente", cascade = CascadeType.ALL)
	private List<Grupo> grupos;

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public String toString() {
		return "Docente [grupos=" + grupos + "]";
	}
	
	

}
