package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.MatriculaDAO;
import ec.edu.ups.modelo.Matricula;

@Stateless
public class MatriculaON {

	@Inject
	private MatriculaDAO matriculaDAO;

	public void guardar(Matricula matricula) throws Exception {
		matriculaDAO.save(matricula);
	}

	public List<Matricula> getListaMatriculas() {
		return matriculaDAO.getMatriculas();
	}

	public Matricula getMatricula(int id) {
		return matriculaDAO.getMatricula(id);
	}

	public void borrar(int id) throws Exception {
		try {
			matriculaDAO.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al borrar MATRICULA " + e.getMessage());
		}
	}
}
