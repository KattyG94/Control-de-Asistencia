package ec.edu.ups.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Rol {
	@Id
	private int codigo;
	private String nombreRol;
	public int getCodigo() {
		return codigo;
	}
	@OneToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinColumn(name="rol_codigo")
	private List<DocenteRol> roles;
	
	
	
	public List<DocenteRol> getRoles() {
		return roles;
	}
	public void setRoles(List<DocenteRol> roles) {
		this.roles = roles;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	
	

}
