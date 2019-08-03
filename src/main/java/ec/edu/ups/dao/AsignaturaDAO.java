package ec.edu.ups.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBTransactionRolledbackException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Silabo;

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
	public List<Silabo> listaSilaboByGrupoIds(int id){
		List<Silabo>listaSilabo=new ArrayList<Silabo>();
		try {
			String jpql="SELECT s FROM Silabo s JOIN s.asignatura an WHERE an.id =: id";
			Query query=manager.createQuery(jpql,Silabo.class);
			query.setParameter("id", id);
			listaSilabo=query.getResultList();
		} catch (EJBTransactionRolledbackException e) {
			// TODO: handle exception
		}
		return listaSilabo;
	}
	public List<Asignatura> listarSilaboByGrupoId(int id){
		List<Asignatura>listaSilabo=new ArrayList<Asignatura>();
		try {
			String jpql="SELECT a FROM Asignatura a"
//					+ " JOIN a.silabos s "
					+ "WHERE a.id =: id";
			Query query=manager.createQuery(jpql,Asignatura.class);
			query.setParameter("id", id);
			listaSilabo=query.getResultList();
		} catch (EJBTransactionRolledbackException e) {
			// TODO: handle exception
		}
		return listaSilabo;
	}

}
