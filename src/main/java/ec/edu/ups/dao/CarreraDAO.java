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

	public void save(Carrera carrera) {
		if (this.read(carrera.getId()) != null) {
			this.update(carrera);
		} else {
			this.create(carrera);
		}
	}

	public void create(Carrera carrera) {
		manager.persist(carrera);
	}

	public Carrera read(int id) {
		return manager.find(Carrera.class, id);
	}

	public void update(Carrera carrera) {
		manager.merge(carrera);
	}

	public void delete(int id) {
		Carrera carrera = read(id);
		manager.remove(carrera);
	}

	public List<Carrera> getCarreras() {
		String jpql = "SELECT carrera FROM Carrera carrera";
		Query query = manager.createQuery(jpql, Carrera.class);
		List<Carrera> carreras = query.getResultList();
		return carreras;
	}

	public Carrera getCarrera(int id) {
		String jpql = "SELECT carrera FROM Carrera carrera WHERE carrera.id =: id";
		Query query = manager.createQuery(jpql, Carrera.class);
		query.setParameter("id", id);
		Carrera carrera = (Carrera) query.getSingleResult();
		return carrera;
	}

}