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
//	public Rol getRolCodigo(String nombreRol){
//		String jpql="SELECT r FROM Rol p.nombreRol LIKE :filtro";
//		Query q=manager.createQuery(jpql,Rol.class);
//		q.setParameter("filtro", "%"+nombreRol+"%");
//		Rol rol=(Rol) q.getResultList();
//		
//		return rol;
//		
//	}
	public Rol buscarRol(String name) {
		String jpql = "SELECT r FROM Rol r WHERE r.nombreRol =: name";
		Query q = manager.createQuery(jpql, Rol.class);
		q.setParameter("name", name);
		Rol rolName = (Rol) q.getSingleResult();
		return rolName;
	}
	
	public List<Rol> getRoles(){
		String jpql = "SELECT r FROM Rol r ";
		Query q = manager.createQuery(jpql, Rol.class);
		List<Rol> roles = q.getResultList();
		return roles;
	}
}
