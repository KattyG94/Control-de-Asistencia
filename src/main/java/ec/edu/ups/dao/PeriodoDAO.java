package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Periodo;

@Stateless
public class PeriodoDAO {
	@Inject
	private EntityManager manager;
	
	public void createPeriodo(Periodo perido) {
		if(this.read(perido.getId())!=null)
			this.update(perido);
		else
			this.create(perido);
	}
	private void create(Periodo p) {
		manager.persist(p);
	}
	private void update(Periodo p) {
		manager.merge(p);
	}
	public Periodo read(int id) {
		return manager.find(Periodo.class, id);
	}
	public void delete(int id) {
		Periodo p=read(id);
		manager.remove(p);
	}
	public List<Periodo> getPeriodos(){
		String jpql="SELECT p FROM Periodo p";
		Query query=manager.createQuery(jpql,Periodo.class);
		List<Periodo>listaPeriodo=query.getResultList();
		return listaPeriodo;
	}

}
