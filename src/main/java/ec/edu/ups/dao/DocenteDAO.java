package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.modelo.Docente;

@Stateless
public class DocenteDAO {

	@Inject
	private EntityManager manager;

	public void save(Docente d) {
		if (this.read(d.getId()) != null)
			this.update(d);
		else
			this.create(d);
	}

	public void create(Docente d) {
		manager.persist(d);
	}

	public Docente read(int id) {
		return manager.find(Docente.class, id);
	}

	public void update(Docente d) {
		manager.merge(d);

	}

	public void delete(int id) {
		Docente d = read(id);
		manager.remove(d);
	}

	public List<Docente> getDocentes() {
		String jpql = "SELECT d FROM Docente d";
		Query q = manager.createQuery(jpql, Docente.class);
		List<Docente> docentes = q.getResultList();
		return docentes;

	}

	public Docente getDocente(int id) {
		String jpql = "SELECT d FROM Docente d WHERE d.id =: id";
		Query q = manager.createQuery(jpql, Docente.class);
		q.setParameter("id", id);
		Docente docentes = (Docente) q.getSingleResult();
		System.out.println(docentes.toString());
		return docentes;
	}
	public Docente getDocente1(Docente id) {
		String jpql = "SELECT d FROM Docente d WHERE d.profesion =: id";
		Query q = manager.createQuery(jpql, Docente.class);
		q.setParameter("id", id.getProfesion());
		Docente docentes = (Docente) q.getSingleResult();
		System.out.println(docentes.toString());
		return docentes;
	}
	
//	public Docente getUsuarioDocente(Docente d) {
//	Docente docenteV=null;
//	try {
//		System.out.println("Prsente");
//		String jpql="SELECT d FROM Docente d WHERE d.correo =: user AND d.contrasena =: pass";
//		Query q = manager.createQuery(jpql,Docente.class);
//		q.setParameter("user", d.getCorreo());
//		q.setParameter("pass", d.getContrasena());
//		List<Docente> docenteLista = q.getResultList();
//		if(!docenteLista.isEmpty()) {
//			docenteV=docenteLista.get(0);
//		}
//	} catch (Exception e) {
//		throw e;
//	}
//	return docenteV;
//	}
	
	public Docente getUsuarioDocente(String user,String pass) {
	Docente docenteV=null;
	try {
		System.out.println("Prsente");
		String jpql="SELECT d FROM Docente d WHERE d.correo =: user AND d.contrasena =: pass";
		Query q = manager.createQuery(jpql,Docente.class);
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		List<Docente> docenteLista = q.getResultList();
		if(!docenteLista.isEmpty()) {
			docenteV=docenteLista.get(0);
		}
	} catch (Exception e) {
		throw e;
	}
	return docenteV;
	}


}
