package ec.edu.ups.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Docente extends Persona{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "profesion")
	private String profesion;

	@NotNull
	@Column(name = "nivelEstudio")
	private String nivelEstudio;

	@NotNull
	@Column(name = "usuario")
	private String usuario;

	@NotNull
	@Column(name = "clave")
	private String clave;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNivelEstudio() {
		return nivelEstudio;
	}

	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", profesion=" + profesion + ", nivelEstudio=" + nivelEstudio + ", usuario="
				+ usuario + ", clave=" + clave + "]";
	}

	
}
