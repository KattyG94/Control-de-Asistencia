package ec.edu.ups.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import ec.edu.ups.modelo.Rol;
import ec.edu.ups.on.DocenteON;

@ManagedBean
public class RolControlador {
	private Rol rol;
private List<SelectItem> roles;
	
	@Inject
	private DocenteON dON;

	public Rol getRol() {
		return rol;
	}
	@PostConstruct
	public void init() {
		rol=new Rol();
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<SelectItem> getRoles() {
		this.roles=new ArrayList<SelectItem>();
		List<Rol>listitaRol=dON.getRoles();
		roles.clear();
		for (Rol rol : listitaRol) {
			SelectItem rolesItem=new SelectItem(rol.getCodigo(),rol.getNombreRol());
			this.roles.add(rolesItem);
		}
		return roles;
	}

	public void setRoles(List<SelectItem> roles) {
		this.roles = roles;
	}

	public void buscarRol() {
		System.out.println(rol.getCodigo());
	}
	
	
}
