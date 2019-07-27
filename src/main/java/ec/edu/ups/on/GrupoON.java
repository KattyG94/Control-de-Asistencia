package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.GrupoDAO;
import ec.edu.ups.modelo.Grupo;


@Stateless
public class GrupoON {

	@Inject
	private GrupoDAO grupoDao;
	
	public void guardarGrupo(Grupo grupo) throws Exception{
		grupoDao.crearGrupo(grupo);
	}
	public void eliminarGrupo(int id) throws Exception {
		try {
			grupoDao.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Grupo getGrupo(int id) {
		Grupo grupo=grupoDao.read(id);
		return grupo;
	}
	public List<Grupo> getGrupos(){
		List<Grupo> listaP=grupoDao.getGrupos();
		return listaP;
	}
}
