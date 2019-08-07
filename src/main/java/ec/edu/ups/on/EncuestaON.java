package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.EncuestaDAO;
import ec.edu.ups.modelo.Encuesta;
import ec.edu.ups.modelo.Opcion;
import ec.edu.ups.modelo.Resultado_Encuesta;

@Stateless
public class EncuestaON {
	@Inject
	private EncuestaDAO dao;

	public void guardar(Encuesta a) {
		dao.save(a);
	}

	public List<Encuesta> getEncuesta() {
		return dao.getEncuesta();
	}

	public Encuesta getEncuesta(int id) {
		Encuesta a = dao.read(id);
		return a;
	}
	
	public List<Resultado_Encuesta> getResultadoEncuesta(int id) {
		List<Resultado_Encuesta> result = dao.getResultadoEncuesta(id);
		return result;
	}

	public void borra(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}

	public List<Encuesta> getListarEncuesta() {
		List<Encuesta> lista = dao.getEncuesta();
		return lista;
	}

	public List<Opcion> listaOpcionesByEncuestaId(int id) {
		List<Opcion> listaOp = dao.listaOpcionesByEncuesta(id);
		return listaOp;
	}
}
