package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AsignaturaDAO;
import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Silabo;

@Stateless
public class AsingnaturaON {
	@Inject
	private AsignaturaDAO asignaturaDao;
	
	public void guardarAsignatura(Asignatura asignatura) throws Exception{
		asignaturaDao.createAsignatura(asignatura);
	}
	public void eliminarAsignatura(int id) throws Exception {
		try {
			asignaturaDao.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Asignatura getAsignatura(int id) {
		Asignatura per=asignaturaDao.read(id);
		return per;
	}
	public List<Asignatura> getAsignatura(){
		List<Asignatura> listaP=asignaturaDao.getAsignatura();
		return listaP;
	}
	public List<Silabo> listaSilaboByAsignaturId(int id){
		List<Silabo> lista=asignaturaDao.listaSilaboByGrupoIds(id);
		return lista;
	}
	public List<Asignatura>listaSilaboByAsignaturaID(int id){
		List<Asignatura> listaAsignatura=asignaturaDao.listarSilaboByGrupoId(id);
	return listaAsignatura;
	}
}
