package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Grupo;
@Stateless
public class GrupoDAO {
	@Inject
	private EntityManager manager;
	
	public void crearGrupo(Grupo grupo) {
		if(this.read(grupo.getId())!=null)
			this.update(grupo);
		else
			this.create(grupo);
	}
	private void create(Grupo p) {
		manager.persist(p);
	}
	private void update(Grupo p) {
		manager.merge(p);
	}
	public Grupo read(int id) {
		return manager.find(Grupo.class, id);
	}
	public void delete(int id) {
		Grupo p=read(id);
		manager.remove(p);
	}
	public List<Grupo> getGrupos(){
		String jpql="SELECT p FROM Grupo p";
		Query query=manager.createQuery(jpql,Grupo.class);
		List<Grupo>listaPeriodo=query.getResultList();
		return listaPeriodo;
	}

}
