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
	
	public void guardar(Docente d)throws Exception{
		
//		if(d.getNombre().length()<2)
//			throw new Exception("Dimencion Corta");
		dao.save(d);
	}
	public List<Docente> getListaDocentes(){
		return dao.getDocentes();
	}
//	public void eliminarDocentes(int id){
//		dao.delete(id);
//	}
//public void modificar(Docente d)throws Exception{
//		dao.update(d);
//	}

public Docente getDocente(int id){
	Docente d=dao.read(id);
	return d;
}
public void borra(int codigo) throws Exception{
	try {
		dao.delete(codigo);
	} catch (Exception e) {
		throw new Exception("Error al borrar "+e.getMessage());
	}
	
}
}
