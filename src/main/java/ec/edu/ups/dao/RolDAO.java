package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Rol;

@Stateless
public class RolDAO {
	
	@Inject
	private EntityManager manager;
	
	public void create(Rol d) {
		manager.persist(d);
	}

	public Rol read(int id) {
		return manager.find(Rol.class, id);
	}
	public List<Rol> getRoles(){
		String jpql = "SELECT r FROM Rol r ";
		Query q = manager.createQuery(jpql, Rol.class);
		
		List<Rol> roles = q.getResultList();
		return roles;
	}
}
