package on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TemaDAO;
import modelos.Tema;

@Stateless

public class TemaON {

	@Inject
	private TemaDAO tao;

	public void save(Tema t) throws Exception {
		if(tao.read(t.getCodigo())!=null)
			tao.update(t);
		else
			tao.insert(t);
		
	}

	

	public List<Tema> getListadoTemas() {
		return tao.getTemas();
	}

	public Tema getTema(int id) {
		Tema t = tao.read(id);
		return t;
	}

	public void borra(int codigo) throws Exception {
		Tema aux = tao.read(codigo);
		if (aux == null) {
			throw new Exception("Estudiante no registrado");
		} else {
			tao.delete(codigo);
		}
	}

	public void actualizar(Tema tema) throws Exception {
		Tema aux = tao.read(tema.getCodigo());
		if (aux == null) {
			throw new Exception("Tema no registrado");
		} else {
			tao.update(tema);
		}
	}

	public Tema getTem(int codigo) throws Exception {
		Tema aux = tao.read(codigo);
		if (aux == null) {
			throw new Exception("Tema no existe");
		} else {
			return aux;
		}
	}

	public Tema buscar(int codigo) {
		return tao.buscarTema(codigo);
	}

}
