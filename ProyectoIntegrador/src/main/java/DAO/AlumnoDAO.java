package DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import modelos.Alumno;

@Stateless
public class AlumnoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Alumno alumno) {
		em.persist(alumno);
	}
	
	public void update(Alumno alumno) {
		em.merge(alumno);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Alumno read(int id) {
		Alumno aux= em.find(Alumno.class, id);
		return aux;
	}
	
	public List<Alumno> getAlumnos(){
		String jpql="SELECT a FROM Alumno a";
		Query q=em.createQuery(jpql, Alumno.class);
		List<Alumno> lista=q.getResultList();
		return lista;
	}
	
	public Alumno bAlumno(int id) {
		Alumno alumno=em.find(Alumno.class, id);
		return alumno;
		
	}
}
