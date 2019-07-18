package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.on.DocenteON;

@ManagedBean
public class RolControlador {
public List<Rol> roles;
	
	@Inject
	private DocenteON gON;
	
	@PostConstruct
	public void init() {
		roles =  gON.getRoles();
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
