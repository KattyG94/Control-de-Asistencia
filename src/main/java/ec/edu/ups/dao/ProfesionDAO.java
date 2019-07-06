package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Profesion;

@Stateless
public class ProfesionDAO {
	private EntityManager em;
	
	public void insert(Profesion p) {
		em.persist(p);
	}
	public List<Profesion> getProfesiones(){
		String jpql = "SELECT p FROM Proefesion p ";
		
		Query q = em.createQuery(jpql, Profesion.class);
		
		List<Profesion> profesions = q.getResultList();
		return profesions;
		
	}

}
