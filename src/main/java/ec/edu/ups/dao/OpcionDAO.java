package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Opcion;

@Stateless
public class OpcionDAO {

	@Inject
	private EntityManager manager;

	private void create(Opcion opcion) {
		manager.persist(opcion);
	}

	private Opcion read(int id) {
		return manager.find(Opcion.class, id);
	}

	private List<Opcion> getOpciones() {
		String jpql = "SELECT op FROM Opcion";
		Query query = manager.createQuery(jpql, Opcion.class);
		List<Opcion> lista = query.getResultList();

		return lista;
	}

}
