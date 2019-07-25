package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Silabo;

@Stateless
public class SilaboDAO {
	@Inject
	private EntityManager manager;

	private void create(Silabo silabo) {
		manager.persist(silabo);
	}
	private Silabo read(int id) {
		return manager.find(Silabo.class, id);
	}
	private List<Silabo> getSilabos(){
		String jpql="SELECT s FROM Silabo";
		Query query=manager.createQuery(jpql,Silabo.class);
		List<Silabo> lista=query.getResultList();
		
		return lista;
	}
}
