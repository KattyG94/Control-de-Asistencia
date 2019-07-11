package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.AsignaturaDAO;
import ec.edu.ups.modelo.Asignatura;


@Stateless
public class AsignaturaON {

	@Inject
	private AsignaturaDAO adao;
	
	public void save(Asignatura asignatura) throws Exception {
		Asignatura aux= adao.read(asignatura.getCodigo());
		if (aux != null) {
			throw new Exception("Asignatura ya registrada");
		} else {
			adao.insert(asignatura);
		}
	}

	public List<Asignatura> getListadoAsignatura(){
		return adao.getAsignatura();
	}	
	
	public void eliminar(int codigo) throws Exception{
		Asignatura aux=adao.read(codigo);
		if (aux == null) {
			throw new Exception("Asignatura no registrada");
		} else {
			adao.remove(codigo);
		}
	}
	
	public void actualizar(Asignatura asignatura) throws Exception {
		Asignatura aux=adao.read(asignatura.getCodigo());
		if (aux == null) {
			throw new Exception("Asignatura no registrada");
		} else {
			adao.update(asignatura);
		}
	}
	
	public Asignatura getAsig(int codigo) throws Exception{
		Asignatura aux=adao.read(codigo);
		if (aux == null) {
			throw new Exception("Asignatura no existe");
		}else {
			return aux;
		}
	}
	
	public Asignatura buscar(int codigo) throws Exception{
		Asignatura aux=adao.read(codigo);
		if (aux == null) {
			throw new Exception("Codigo no existe");
		}else {
			return aux;
		}
	}
}
