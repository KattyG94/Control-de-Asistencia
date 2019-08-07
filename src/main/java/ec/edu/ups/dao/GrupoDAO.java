package ec.edu.ups.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Carrera;
import ec.edu.ups.modelo.Encuesta;
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
	public void create(Grupo p) {
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
	public Grupo getCrupoID(Grupo id){
		String jpql="SELECT g FROM Grupo g WHERE g.id =: id";
		Query query=manager.createQuery(jpql,Grupo.class);
		query.setParameter("id", id.getId());
		Grupo grupo=(Grupo)query.getSingleResult();
		return grupo;
	}

	
	public List<Grupo> getlistaGrupoIdDocente(int id){
		String jpql="SELECT g FROM Grupo g" + 
				"JOIN g.Asignatura a" + 
				"JOIN g.Docente d" + 
				"JOIN g.Carrera c" + 
				"WHERE g.id =: id";
		Query query=manager.createQuery(jpql,Grupo.class);
		query.setParameter("id", id);
		List<Grupo>listado=query.getResultList();	
		return listado;
		
	}
	public List<Asignatura> getlistaGrupoAsignatura(int id){
		String jpql="SELECT a FROM Asignatura a JOIN a.grupos gmc where gmc.docente.id = ?1";
		Query query=manager.createQuery(jpql,Asignatura.class);
		query.setParameter(1, id);
		List<Asignatura>listado=query.getResultList();	
		return listado;
		
	}
	
	public List<Encuesta> getlistaGrupoEncuesta(int id){
		String jpql="SELECT en FROM Encuesta en JOIN en.grupo_encuesta gen where gen.id = ?1";
		Query query=manager.createQuery(jpql,Encuesta.class);
		query.setParameter(1, id);
		List<Encuesta>listado=query.getResultList();	
		return listado;
		
	}
	
	public List<Grupo> getlistaGrupoNumAsignatura(int id){
		String jpql="SELECT g FROM Grupo g JOIN g.docente gmc where gmc.id = ?1";
		Query query=manager.createQuery(jpql,Grupo.class);
		query.setParameter(1, id);
		List<Grupo>listado=query.getResultList();	
		return listado;
		
	}
	public List<Grupo> getlistaGrupoByEstudianteId(int id){
		String jpql="SELECT g FROM Grupo g JOIN g.matricula mat where mat.alumno.id = ?1";
		Query query=manager.createQuery(jpql,Grupo.class);
		query.setParameter(1, id);
		List<Grupo>listado=query.getResultList();	
		return listado;
		
	}
	public List<Grupo> getlistaGrupo(int id){
		String jpql="SELECT g FROM Grupo g WHERE g.id =: cod";
		Query query=manager.createQuery(jpql,Grupo.class);
		query.setParameter("cod", id);
		List<Grupo>listado=query.getResultList();	
		return listado;
		
	}

}
