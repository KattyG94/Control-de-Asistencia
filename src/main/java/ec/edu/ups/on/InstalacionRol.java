package ec.edu.ups.on;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.modelo.Rol;

@Startup
@Singleton
public class InstalacionRol {
	@Inject
	private RolDAO dao;
	
	private List<Rol>listaRol;
	
	@PostConstruct
	public void init() {
		listaRol=dao.getRoles();
		if(listaRol.size()==0) {
			Rol r=new Rol();
			r.setNombreRol("Docente");
			dao.create(r);
			Rol r1=new Rol();
			r1.setNombreRol("Jefe de Area");
			dao.create(r1);
			listaRol=dao.getRoles();
		}	else {
			listaRol=dao.getRoles();
		}
	}

	public List<Rol> getListaRol() {
		return listaRol;
	}

}
