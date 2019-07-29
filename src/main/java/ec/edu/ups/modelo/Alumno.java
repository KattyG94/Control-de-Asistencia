package ec.edu.ups.modelo;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Alumno extends Usuario {
//	@JoinTable(name = "rel_grup_alum", joinColumns = @JoinColumn(name = "FK_GRUPO", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_ALUMNO", nullable = false))
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "alumno_codigo")
//	private List<Grupo> grupos;
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Matricula>matricula;

//	public List<Grupo> getGrupos() {
//		return grupos;
//	}
//	public void setGrupos(List<Grupo> grupos) {
//		this.grupos = grupos;
//	}
	

	public List<Matricula> getMatricula() {
		return matricula;
	}
<<<<<<< HEAD
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
=======
	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
>>>>>>> Angel
	}
	@Override
	public String toString() {
		return "Alumno [matricula=" + matricula + "]";
	}
	
	

}
