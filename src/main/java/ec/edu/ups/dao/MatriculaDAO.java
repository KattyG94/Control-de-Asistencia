package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Matricula;

@Stateless
public class MatriculaDAO {

	@Inject
	private EntityManager manager;

	public void save(Matricula matricula) {
		if (this.read(matricula.getId()) != null) {
			this.update(matricula);
		} else {
			this.create(matricula);
		}
	}

	public void create(Matricula matricula) {
		manager.persist(matricula);
	}

	public Matricula read(int id) {
		return manager.find(Matricula.class, id);
	}

	public void update(Matricula matricula) {
		manager.merge(matricula);
	}

	public void delete(int id) {
		Matricula matricula = read(id);
		manager.remove(matricula);
	}

	public List<Matricula> getMatriculas() {
		String jpql = "SELECT matricula FROM Matricula matricula";
		Query query = manager.createQuery(jpql, Matricula.class);
		List<Matricula> matriculas = query.getResultList();
		return matriculas;
	}

	public Matricula getMatricula(int id) {
		String jpql = "SELECT matricula FROM Matricula matricula WHERE matricula.id =: id";
		Query query = manager.createQuery(jpql, Matricula.class);
		query.setParameter("id", id);
		Matricula matricula = (Matricula) query.getSingleResult();
		return matricula;
	}

}