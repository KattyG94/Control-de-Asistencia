package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AsistenciaDAO;
import ec.edu.ups.modelo.Asistencia;

@Stateless
public class AsistenciaON {
	@Inject
	private AsistenciaDAO asistenciaDao;
	
	public void registrarAsistencia(Asistencia asistencia) throws Exception{
		asistenciaDao.registarAsistencia(asistencia);
	}
	public void eliminarAsistencia(int id) throws Exception {
		try {
			asistenciaDao.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Asistencia getAsistencia(int id) {
		Asistencia per=asistenciaDao.read(id);
		return per;
	}
	public List<Asistencia> getAsistencia(){
		List<Asistencia> listaP=asistenciaDao.getAsistencia();
		return listaP;
	}
	public List<Asistencia> getListadoAsistencia(String date, int id){
		List<Asistencia> lista=asistenciaDao.getlistadoAsistencia(date, id);
		return lista;
	}
}
