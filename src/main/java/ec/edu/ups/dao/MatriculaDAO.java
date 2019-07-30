package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Matricula;

@Stateless
public class MatriculaDAO {
	@Inject
	private EntityManager manager;
	
	public void createMatricula(Matricula matricula) {
		if(this.read(matricula.getCodigo())!=null)
			this.update(matricula);
		else
			this.create(matricula);
	}
	private void create(Matricula matricula) {
		manager.persist(matricula);
	}
	private void update(Matricula matricula) {
		manager.merge(matricula);
	}
	public Matricula read(int id) {
		return manager.find(Matricula.class, id);
	}
	public void delete(int id) {
		Matricula p=read(id);
		manager.remove(p);
	}
	//String jpql="SELECT a FROM Alumno a JOIN a.matricula pmc where pmc.grupo.id = ?1";
	public List<Matricula> getMatriculas(int codigo){
		String jpql="SELECT m FROM Matricula m JOIN m.grupo gmc where gmc.id = ?1";
		Query query=manager.createQuery(jpql,Matricula.class);
		query.setParameter(1, codigo);
		List<Matricula>listaMatriculas=query.getResultList();
		return listaMatriculas;
	}

}
