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

	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Matricula>matricula;


	

	public List<Matricula> getMatricula() {
		return matricula;
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
=======
	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
>>>>>>> Angel
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
