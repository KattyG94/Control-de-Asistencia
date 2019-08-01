package ec.edu.ups.on;

import java.sql.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ec.edu.ups.dao.DocenteDAO;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.Rol;

@Startup
@Singleton
public class InstalacionRol {
	@Inject
	private DocenteDAO dao;
	
//	private List<Rol>listaRol;
	
	@PostConstruct
	public void init() {
		Docente d=new Docente();
		d.setNombres("Juan");
		d.setApellidos("Perez");
		d.setCedula("1900790681");
		d.setCorreo("admin@gmail.com");
		d.setContrasena("admin");
		d.setDireccion("Cuenca");
		d.setProfesion("Abogado/a");
		d.setRol("Jefe de Area");
		d.setTelefono("0987654321");
		d.setGenero("Masculino");
		d.setFechaNac(new java.util.Date());
		dao.create(d);
		
	}


}

