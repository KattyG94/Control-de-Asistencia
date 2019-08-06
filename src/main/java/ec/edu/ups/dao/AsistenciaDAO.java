package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Asistencia;

@Stateless
public class AsistenciaDAO {
	@Inject
	private EntityManager manager;
	
	public void registarAsistencia(Asistencia asistencia) {
		if(this.read(asistencia.getId())!=null)
			this.update(asistencia);
		else
			this.create(asistencia);
	}
	private void create(Asistencia p) {
		manager.persist(p);
	}
	private void update(Asistencia p) {
		manager.merge(p);
	}
	public Asistencia read(int id) {
		return manager.find(Asistencia.class, id);
	}
	public void delete(int id) {
		Asistencia p=read(id);
		manager.remove(p);
	}
	public List<Asistencia> getAsistencia(){
		String jpql="SELECT a FROM Aistencia a";
		Query query=manager.createQuery(jpql,Asistencia.class);
		List<Asistencia>listado=query.getResultList();
		return listado;
	}
}
