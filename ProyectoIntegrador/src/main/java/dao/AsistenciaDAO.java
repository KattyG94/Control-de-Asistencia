//package dao;
//
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import modelos.Asistencia;
//
//public class AsistenciaDAO {
//
//	private EntityManager em;
//
//	public void insert(Asistencia a) {
//		em.persist(a);
//
//	}
//
//	public Asistencia read(int id) {
//		return em.find(Asistencia.class, id);
//	}
//
//	public void update(Asistencia a) {
//		em.merge(a);
//	}
//
//	public void delete(int id) {
//
//		Asistencia a = read(id);
//		em.remove(a);
//	}
//
//	public List<Asistencia> getAsistencias() {
//		String jpql = "SELECT a FROM Asistencia a";
//
//		Query q = em.createQuery(jpql, Asistencia.class);
//		List<Asistencia> asistencias = q.getResultList();
//
//		return asistencias;
//	}
//
//	public List<Asistencia> getAsistenciasPorNombre(String filtroBusqued) {
//		String jpql = "SELECT a FROM Asistencia a WHERE a.nombre LIKE :filtro        ";
//
//		Query q = em.createQuery(jpql, Asistencia.class);
//		q.setParameter(":filtro", "%" + filtroBusqued + "%");
//		List<Asistencia> asistencias = q.getResultList();
//
//		return asistencias;
//	}
//}
