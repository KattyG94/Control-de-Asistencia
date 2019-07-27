package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.DocenteRol;

@Stateless
public class DocenteRolDAO {

	@Inject
	private EntityManager em;

	public void save(DocenteRol t) {
		this.create(t);

	}

	public void create(DocenteRol t) {
		em.persist(t);
	}

	public DocenteRol read(int id) {
		return em.find(DocenteRol.class, id);
	}

	public void update(DocenteRol p) {

		em.merge(p);
	}

	public void delete(int id) {
		DocenteRol p = read(id);
		em.remove(p);
	}

	public List<DocenteRol> getDocenteRol() {
		String jpql = "SELECT t FROM DocenteRol t ";

		Query q = em.createQuery(jpql, DocenteRol.class);

		List<DocenteRol> doceteRol = q.getResultList();
		return doceteRol;
	}

}
