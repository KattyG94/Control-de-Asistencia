package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.ComentariosDAO;
import ec.edu.ups.modelo.Comentarios;

@Stateless
public class ComentariosON {
	@Inject
	private ComentariosDAO dao;

	public void guardar(Comentarios a) {
		dao.save(a);
	}

	public List<Comentarios> getEncuesta() {
		return dao.getComentarios();
	}

	public Comentarios getComentarios(int id) {
		Comentarios a = dao.read(id);
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
