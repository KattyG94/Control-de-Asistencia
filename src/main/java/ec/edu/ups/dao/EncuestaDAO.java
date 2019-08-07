package ec.edu.ups.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Encuesta;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.modelo.Opcion;
import ec.edu.ups.modelo.Resultado_Encuesta;

@Stateless
public class EncuestaDAO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	public void save(Encuesta d) {
		if (this.read(d.getId()) != null)
			this.update(d);
		else
			this.create(d);
	}

	public void create(Encuesta d) {
		manager.persist(d);
	}

	public Encuesta read(int id) {
		return manager.find(Encuesta.class, id);
	}

	public void update(Encuesta d) {
		manager.merge(d);

	}

	public void delete(int id) {
		Encuesta d = read(id);
		manager.remove(d);
	}

	public List<Encuesta> getEncuesta() {
		String jpql = "SELECT d FROM Encuesta d";
		Query q = manager.createQuery(jpql, Encuesta.class);
		List<Encuesta> docentes = q.getResultList();
		return docentes;

	}
	
	public List<Resultado_Encuesta> getResultadoEncuesta(int id) {
		String jpql = "SELECT re FROM Resultado_Encuesta re JOIN re.encuesta enc WHERE enc.id = ?1";
		Query query = manager.createQuery(jpql, Resultado_Encuesta.class);
		query.setParameter(1, id);
		List<Resultado_Encuesta> res_encuesta = query.getResultList();
		return res_encuesta;

	}

	public List<Opcion> listaOpcionesByEncuesta(int id) {
		List<Opcion> listaOpciones = new ArrayList<Opcion>();
		try {
			String jpql = "SELECT op FROM Opcion op JOIN op.encuesta en WHERE en.id =: id";
			Query query = manager.createQuery(jpql, Opcion.class);
			query.setParameter("id", id);
			listaOpciones = query.getResultList();
		} catch (EJBTransactionRolledbackException e) {
			// TODO: handle exception
		}
		return listaOpciones;
	}

	public Encuesta getEncuesta(int id) {
		String jpql = "SELECT d FROM Encuesta d WHERE d.id =: id";
		Query q = manager.createQuery(jpql, Encuesta.class);
		q.setParameter("id", id);
		Encuesta docentes = (Encuesta) q.getSingleResult();
		System.out.println(docentes.toString());
		return docentes;
	}
}
