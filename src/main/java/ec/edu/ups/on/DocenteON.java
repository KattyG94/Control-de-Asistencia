package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DocenteDAO;
import ec.edu.ups.modelo.Docente;

@Stateless
public class DocenteON {

	@Inject
	private DocenteDAO dao;

	public void guardar(Docente d) {
		dao.save(d);
	}

	public List<Docente> getListaDocentes() {
		return dao.getDocentes();
	}

	public Docente getDocente(int id) {
		Docente d = dao.getDocente(id);
		return d;
	}

	public void borra(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}
}
