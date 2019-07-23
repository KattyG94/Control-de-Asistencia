package ec.edu.ups.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Docente;

public class LoginDAO {

	@Inject
	private EntityManager manager;

	public Docente getDocente(int id) {
		String jpql = "SELECT d FROM Docente d WHERE d.id =: id";
		Query q = manager.createQuery(jpql, Docente.class);
		q.setParameter("id", id);
		Docente docentes = (Docente) q.getSingleResult();
		System.out.println(docentes.toString());
		return docentes;
	}

	public boolean validarLoginDocente(String correo, String contrasena) {
		String jpql = "SELECT d FROM Docente d WHERE d.correo =: correo AND d.contrasena =: contrasena";
		Query q = manager.createQuery(jpql, Docente.class);
		q.setParameter("correo", correo);
		q.setParameter("contrasena", contrasena);
		Docente docente = (Docente) q.getSingleResult();
		if (docente != null) {
			return true;
		} else {
			return false;
		}
	}
}
