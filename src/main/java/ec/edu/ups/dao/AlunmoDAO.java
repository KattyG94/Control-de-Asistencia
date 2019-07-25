package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Docente;

@Stateless
public class AlunmoDAO {

	@Inject
	private EntityManager manager;

	public void save(Alumno a) {
		if (this.read(a.getId()) != null) {
			this.update(a);
		} else {
			this.create(a);
		}
	}

	public void create(Alumno a) {
		manager.persist(a);
	}

	public Alumno read(int id) {
		return manager.find(Alumno.class, id);
	}

	public void update(Alumno a) {
		manager.merge(a);
	}

	public void delete(int id) {
		Alumno a = read(id);
		manager.remove(a);
	}

	public List<Alumno> getAlumnos() {
		String jpql = "SELECT a FROM Alumno a";
		Query query = manager.createQuery(jpql, Alumno.class);
		List<Alumno> alumnos = query.getResultList();
		return alumnos;
	}

	public Alumno getAlumno(int id) {
		String jpql = "SELECT a FROM Alumno a WHERE a.id =: id";
		Query q = manager.createQuery(jpql, Alumno.class);
		q.setParameter("id", id);
		Alumno alumno = (Alumno) q.getSingleResult();
		return alumno;
	}

}
