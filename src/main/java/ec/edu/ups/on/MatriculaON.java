package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.MatriculaDAO;
import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.modelo.Matricula;

@Stateless
public class MatriculaON {
	@Inject
	private MatriculaDAO matriculaON;
	
	public void guardarMatricula(Matricula matricula) throws Exception{
		matriculaON.createMatricula(matricula);
	}
	public void eliminarMatricula(int id) throws Exception {
		try {
			matriculaON.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Matricula getMatricula(int id) {
		Matricula matr=matriculaON.read(id);
		return matr;
	}
	public List<Matricula> getMatriculas(){
		List<Matricula> listaP=matriculaON.getMatriculas();
		return listaP;
	}

}
