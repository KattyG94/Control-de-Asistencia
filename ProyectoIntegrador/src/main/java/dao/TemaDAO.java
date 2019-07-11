package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Tema;

@Stateless
public class TemaDAO {
	@Inject
	private EntityManager em;

	public void insert(Tema t) {
		em.persist(t);
	}

	public Tema read(int id) {
		return em.find(Tema.class, id);
	}

	public void update(Tema t) {
		em.merge(t);
	}

	public void delete(int id) {

		Tema t = read(id);
		em.remove(t);
	}

	public List<Tema> getTemas() {
		String jpql = "SELECT t FROM Tema t";

		Query q = em.createQuery(jpql, Tema.class);
		List<Tema> temas = q.getResultList();

		return temas;
	}

	public List<Tema> getTemasPorNombre(String filtroBusqued) {
		String jpql = "SELECT t FROM Tema t WHERE t.descripcion LIKE :filtro        ";

		Query q = em.createQuery(jpql, Tema.class);
		q.setParameter(":filtro", "%" + filtroBusqued + "%");
		List<Tema> temas = q.getResultList();

		return temas;
	}
	
	public Tema buscarTema(int codigo) {
		Tema tema=em.find(Tema.class, codigo);
		return tema;
	}
}
