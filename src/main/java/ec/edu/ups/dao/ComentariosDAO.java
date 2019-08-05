package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Comentarios;

@Stateless
public class ComentariosDAO {
	@Inject
	private EntityManager manager;

	public void save(Comentarios d) {
		if (this.read(d.getId()) != null)
			this.update(d);
		else
			this.create(d);
	}

	public void create(Comentarios d) {
		manager.persist(d);
	}

	public Comentarios read(int id) {
		return manager.find(Comentarios.class, id);
	}

	public void update(Comentarios d) {
		manager.merge(d);

	}

	public void delete(int id) {
		Comentarios d = read(id);
		manager.remove(d);
	}

	public List<Comentarios> getComentarios() {
		String jpql = "SELECT d FROM Comentarios d";
		Query q = manager.createQuery(jpql, Comentarios.class);
		List<Comentarios> comentarios = q.getResultList();
		return comentarios;

	}

	public Comentarios getComentarios(int id) {
		String jpql = "SELECT d FROM Comentarios d WHERE d.id =: id";
		Query q = manager.createQuery(jpql, Comentarios.class);
		q.setParameter("id", id);
		Comentarios comentarios = (Comentarios) q.getSingleResult();
		System.out.println(comentarios.toString());
		return comentarios;
	}
}
