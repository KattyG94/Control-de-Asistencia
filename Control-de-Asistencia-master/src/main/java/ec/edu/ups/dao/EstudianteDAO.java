package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Estudiante;


@Stateless
public class EstudianteDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Estudiante estudiante) {
		em.persist(estudiante);
	}
	
	public void update(Estudiante estudiante) {
		em.merge(estudiante);
	}
	
	public void remove(String cedula) {
		em.remove(read(cedula));
	}
	
	public Estudiante read(String cedula) {
		Estudiante aux= em.find(Estudiante.class, cedula);
		return aux;
	}
	
	public List<Estudiante> getEstudiantes(){
		String jpql="SELECT e FROM Estudiante e";
		Query q=em.createQuery(jpql, Estudiante.class);
		List<Estudiante> lista=q.getResultList();
		return lista;
	}
	
	public List<Estudiante> getEst(String cedula){
		String jpql1="SELECT e FROM Estudiante e WHERE ?1";
		Query q=em.createQuery(jpql1, Estudiante.class);
		List<Estudiante> lista=q.getResultList();
		return lista;
	}
}