package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Asignatura;

@Stateless
public class AsignaturaDAO {
	@Inject
	private EntityManager manager;
	
	public void createAsignatura(Asignatura asignatura) {
		if(this.read(asignatura.getId())!=null)
			this.update(asignatura);
		else
			this.create(asignatura);
	}
	private void create(Asignatura p) {
		manager.persist(p);
	}
	private void update(Asignatura p) {
		manager.merge(p);
	}
	public Asignatura read(int id) {
		return manager.find(Asignatura.class, id);
	}
	public void delete(int id) {
		Asignatura p=read(id);
		manager.remove(p);
	}
	public List<Asignatura> getAsignatura(){
		String jpql="SELECT a FROM Asignatura a";
		Query query=manager.createQuery(jpql,Asignatura.class);
		List<Asignatura>listaPeriodo=query.getResultList();
		return listaPeriodo;
	}

}
