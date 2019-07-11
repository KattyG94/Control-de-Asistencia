package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.modelo.Docente;

@Stateless
public class DocenteDAO {
	@Inject
	private EntityManager manager;

	public void save(Docente d) {
		System.out.println(d.toString());

		if (this.read(d.getId()) != null)
			this.update(d);
		else
			this.create(d);
	}

	public void create(Docente d) {
		manager.persist(d);
	}

	public Docente read(int id) {
		return manager.find(Docente.class, id);
	}

	public void update(Docente d) {
		manager.merge(d);

	}

	public void delete(int id) {
		Docente d = read(id);
		manager.remove(d);
	}

	public List<Docente> getDocentes() {
		String jpql = "SELECT d FROM Docente d";
		Query q = manager.createQuery(jpql, Docente.class);
		List<Docente> docentes = q.getResultList();
		return docentes;

	}

//	public List<Docente> getDocenteNombre(String nombre) {
//		String jpql = "SELECT d FROM Docente d.nombre LIKE:filtro";
//		Query q = manager.createQuery(jpql, Docente.class);
//		q.setParameter("filtro", "%" + nombre + "%");
//		List<Docente> docentes = q.getResultList();
//		return docentes;
//	}

	public Docente getDocente(int id) {
		String jpql = "SELECT d FROM Docente d WHERE d.id =: id";
		Query q = manager.createQuery(jpql, Docente.class);
		q.setParameter("id", id);
		Docente docentes = (Docente) q.getSingleResult();
		System.out.println(docentes.toString());
		return docentes;
	}
}
