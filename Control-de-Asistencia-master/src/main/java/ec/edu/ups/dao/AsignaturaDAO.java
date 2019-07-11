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
	private EntityManager am;
	
	public void insert(Asignatura asignatura) {
		am.persist(asignatura);
	}
	
	public void update(Asignatura asignatura) {
		am.merge(asignatura);
	}
	
	public void remove(int codigo) {
		am.remove(read(codigo));
	}
	
	public Asignatura read(int codigo) {
		Asignatura aux= am.find(Asignatura.class, codigo);
		return aux;
	}
	
	public List<Asignatura> getAsignatura(){
		String jpql="SELECT a FROM Asignatura a";
		Query q=am.createQuery(jpql, Asignatura.class);
		List<Asignatura> lista=q.getResultList();
		return lista;
	}
	
}
