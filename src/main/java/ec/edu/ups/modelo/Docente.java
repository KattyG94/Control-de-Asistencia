package ec.edu.ups.modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;



@Entity
public class Docente extends Usuario{
	
	@NotNull
	@Column(name = "profesion")
	private String profesion;

	@NotNull
	@Column(name = "nivelEstudio")
	private String nivelEstudio;
	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="docente_codigo")
	private List<DocenteRol> roles;
	

	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



	public String getNivelEstudio() {
		return nivelEstudio;
	}



	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}
	public List<DocenteRol> getRoles() {
		return roles;
	}



	public void setRoles(List<DocenteRol> roles) {
		this.roles = roles;
	}



	public void addDocenteRol(DocenteRol dRl) {
		if(roles==null)
		   roles = new ArrayList<>();
		
		this.roles.add(dRl);
	}

	@Override
	public String toString() {
		return "Docente [profesion=" + profesion + ", nivelEstudio=" + nivelEstudio + ", roles=" + roles + "]";
	}


	
}
