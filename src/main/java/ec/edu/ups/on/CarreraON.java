package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CarreraDAO;
import ec.edu.ups.modelo.Carrera;

@Stateless
public class CarreraON {

	@Inject
	private CarreraDAO dao;
	public void guardar(Carrera c) {
		dao.save(c);
	}

	public List<Carrera> getCarreras() {
		return dao.getCarreras();
	}

	public Carrera getCarrera(int id) {
		Carrera c = dao.read(id);
		return c;
	}

	public void borra(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}
	}
}
