package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Carrera;

@Stateless
public class CarreraDAO {

	@Inject
	private EntityManager manager;
	
	public void save(Carrera c) {
		if (this.read(c.getId()) != null) {
			this.update(c);
		} else {
			this.create(c);
		}
	}
	
	public void create(Carrera c) {
		manager.persist(c);
	}
	
	public Carrera read(int id) {
		return manager.find(Carrera.class, id);
	}
	
	public void update(Carrera c) {
		manager.merge(c);
	}
	
	public void delete(int id) {
		Carrera c = read(id);
		manager.remove(c);
	}
	
	public List<Carrera> getCarreras(){
		String jpql = "SELECT c FROM Carrera c";
		Query query = manager.createQuery(jpql, Carrera.class);
		List<Carrera> carreras = query.getResultList();
		return carreras;
	}
	
	public Carrera getCarrera(int id) {
		String jpql = "SELECT c FROM Carrera c WHERE c.id =: id";
		Query q = manager.createQuery(jpql,Carrera.class);
		q.setParameter("id", id);
		Carrera carrera = (Carrera) q.getSingleResult();
		return carrera;
	}
	
}
