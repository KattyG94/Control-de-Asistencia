package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.GrupoDAO;
import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Carrera;
import ec.edu.ups.modelo.Grupo;


@Stateless
public class GrupoON {

	@Inject
	private GrupoDAO grupoDao;
	
	public void guardarGrupo(Grupo grupo) throws Exception{
		grupoDao.create(grupo);
	}
	public void eliminarGrupo(int id) throws Exception {
		try {
			grupoDao.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Grupo getGrupo(Grupo id) {
		Grupo grupo=grupoDao.getCrupoID(id);
		return grupo;
	}
	public Grupo getGrupoID(int id) {
		Grupo grupo=grupoDao.read(id);
		return grupo;
	}
	public List<Grupo> getGrupos(){
		List<Grupo> listaP=grupoDao.getGrupos();
		return listaP;
	}
	public List<Grupo> getGruposIdDocente(int id){
		List<Grupo> listaP=grupoDao.getlistaGrupoIdDocente(id);
		return listaP;
	}
	public List<Asignatura> getGruposAsignatura(int id){
		List<Asignatura> listaP=grupoDao.getlistaGrupoAsignatura(id);
		return listaP;
	}
	public List<Grupo> getlistaGrupoAsignatura(int id){
		List<Grupo> listag=grupoDao.getlistaGrupoNumAsignatura(id);
		return listag;
	}
}
