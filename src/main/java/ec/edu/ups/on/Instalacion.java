package ec.edu.ups.on;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import ec.edu.ups.dao.ProfesionDAO;
import ec.edu.ups.modelo.Profesion;

@Startup
@Singleton
public class Instalacion {
	@Inject
	private ProfesionDAO dao;
	
	private List<Profesion>listaProfesion;
	@PostConstruct
	public void init() {
		listaProfesion=dao.getProfesiones();
		if(listaProfesion.size()==0) {
			Profesion p=new Profesion();
			p.setNombre("Abogado");
			dao.insert(p);
			
			Profesion p1=new Profesion();
			p1.setNombre("Arquitecto");
			dao.insert(p1);
			
			listaProfesion=dao.getProfesiones();
			
		}
		
	}
	public List<Profesion> getListaProfesion() {
		return listaProfesion;
	}
	
	
}
