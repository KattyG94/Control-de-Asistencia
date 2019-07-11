package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Docente extends Persona{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
//	@NotNull
//	@Size(min = 1, max = 30)
//	@Column(name = "profesion")
//	private String profesion;

	@NotNull
//	@Size(min = 1, max = 30)
	@Column(name = "nivelEstudio")
	private String nivelEstudio;

	@NotNull
//	@Size(min = 5, max = 30)
	@Column(name = "usuario")
	private String usuario;

	@NotNull
//	@Size(min = 5, max = 30)
	@Column(name = "clave")
	private String clave;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "doc_codigo")
	private List<Profesion>profesiones;

	public Docente() {

	}

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

	public List<Profesion> getProfesiones() {
		return profesiones;
	}

	public void setProfesiones(List<Profesion> profesiones) {
		this.profesiones = profesiones;
	}
	public void addProfesion(Profesion p) {
		if(profesiones==null) {
			profesiones=new ArrayList<>();
		}
		this.profesiones.add(p);
		
	}

	@Override
	public String toString() {
		return "Docente [id=" + id + ", nivelEstudio=" + nivelEstudio + ", usuario=" + usuario + ", clave=" + clave
				+ ", profesiones=" + profesiones + "]";
	}
	
}
