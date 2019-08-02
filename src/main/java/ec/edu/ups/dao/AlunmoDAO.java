package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.Grupo;

@Stateless
public class AlunmoDAO {

	@Inject
	private EntityManager manager;

	public void save(Alumno a) {
		if (this.read(a.getId()) != null) {
			this.update(a);
		} else {
			this.create(a);
		}
	}

	public void create(Alumno a) {
		manager.persist(a);
	}

	public Alumno read(int id) {
		return manager.find(Alumno.class, id);
	}

	public void update(Alumno a) {
		manager.merge(a);
	}

	public void delete(int id) {
		Alumno a = read(id);
		manager.remove(a);
	}

	public List<Alumno> getAlumnos() {
		String jpql = "SELECT a FROM Alumno a";
		Query query = manager.createQuery(jpql, Alumno.class);
		List<Alumno> alumnos = query.getResultList();
		return alumnos;
	}

	public Alumno getAlumno(int id) {
		String jpql = "SELECT a FROM Alumno a WHERE a.id =: id";
		Query q = manager.createQuery(jpql, Alumno.class);
		q.setParameter("id", id);
		Alumno alumno = (Alumno) q.getSingleResult();
		return alumno;
	}
	
	public Alumno getUsuarioAlumno(String user,String pass) {
	Alumno docenteV=null;
	try {
		String jpql="SELECT d FROM Alumno d WHERE d.correo =: user AND d.contrasena =: pass";
		Query q = manager.createQuery(jpql,Alumno.class);
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		List<Alumno> docenteLista = q.getResultList();
		if(!docenteLista.isEmpty()) {
			docenteV=docenteLista.get(0);
		}
	} catch (Exception e) {
		throw e;
	}
	return docenteV;
	}

	public Alumno getAlumnoDNI(Alumno alumno) {
		String jpql = "SELECT d FROM Alumno d WHERE d.cedula =: id";
		Query q = manager.createQuery(jpql, Alumno.class);
		q.setParameter("id", alumno.getCedula());
		Alumno al = (Alumno) q.getSingleResult();
		System.out.println(alumno.toString());
		return al;
	}
	public List<Alumno> getListarAlumnosByGrupoId(int id){
		String jpql="SELECT d FROM Alumno d JOIN d.matricula mat where mat.grupo.id = ?1";
		Query query=manager.createQuery(jpql,Alumno.class);
		query.setParameter(1, id);
		List<Alumno>listado=query.getResultList();	
		return listado;
		
	}

}
