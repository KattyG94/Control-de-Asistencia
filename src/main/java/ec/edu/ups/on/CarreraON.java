package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.CarreraDAO;
import ec.edu.ups.modelo.Carrera;

@Stateless
public class CarreraON {

	@Inject
	private CarreraDAO carreraDAO;

	public void guardar(Carrera carrera) throws Exception {
		carreraDAO.save(carrera);
	}

	public List<Carrera> getListaCarreras() {
		return carreraDAO.getCarreras();
	}

	public Carrera getCarrera(int id) {
		return carreraDAO.getCarrera(id);
	}

	public void borrar(int id) throws Exception {
		try {
			carreraDAO.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al borrar CARRERA " + e.getMessage());
		}
	}
}