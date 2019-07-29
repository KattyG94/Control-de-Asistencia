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

//Prueba de funcionamiento

@Entity
public class Docente extends Usuario {
	
	@NotNull
	@Column(name = "profesion")
	private String profesion;
	
	private String rol;
	
	
//	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
//	@JoinColumn(name="docente_codigo")
//	private List<DocenteRol> roles;
	

	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

//
//	public void addDocenteRol(DocenteRol dRl) {
//		if(roles==null)
//		   roles = new ArrayList<>();
//		
//		this.roles.add(dRl);
//	}

	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	@Override
	public String toString() {
		return "Docente [profesion=" + profesion + ", rol=" + rol + "]";
	}

	
}
