package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AlunmoDAO;
import ec.edu.ups.modelo.Alumno;

@Stateless
public class AlumnoON {

	@Inject
	private AlunmoDAO dao;

	public void guardar(Alumno a) {
		dao.save(a);
	}

	public List<Alumno> getAlumnos() {
		return dao.getAlumnos();
	}

	public Alumno getAlumno(int id) {
		Alumno a = dao.read(id);
		return a;
	}

	public void borra(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}
}
