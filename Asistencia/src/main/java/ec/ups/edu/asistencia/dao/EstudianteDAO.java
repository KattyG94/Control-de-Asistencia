package ec.ups.edu.asistencia.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.asistencia.model.Estudiante;

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
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Estudiante read(int id) {
		Estudiante aux= em.find(Estudiante.class, id);
		return aux;
	}
	
	public List<Estudiante> getEstudiantes(){
		String jpql="SELECT e FROM Estudiante e";
		Query q=em.createQuery(jpql, Estudiante.class);
		List<Estudiante> lista=q.getResultList();
		return lista;
	}
	
	public Estudiante bEstudiante(int id) {
		Estudiante estudiante=em.find(Estudiante.class, id);
		return estudiante;
	}
}
