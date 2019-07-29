package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matricula {
	@Id
	@GeneratedValue
	private int codigo;
	@ManyToOne
	@JoinColumn(name = "codigo_grupo")
	private Grupo grupo;
	@ManyToOne
	@JoinColumn(name = "codigo_alumno")
	private Alumno alumno;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	@Override
	public String toString() {
		return "Matricula [codigo=" + codigo + ", grupo=" + grupo + ", alumno=" + alumno + "]";
	}
	
	

}
