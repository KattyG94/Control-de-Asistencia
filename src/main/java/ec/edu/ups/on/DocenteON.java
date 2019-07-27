package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.DocenteDAO;
import ec.edu.ups.dao.DocenteRolDAO;
import ec.edu.ups.dao.RolDAO;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.modelo.Rol;

@Stateless
public class DocenteON {

	@Inject
	private DocenteDAO dao;

	@Inject
	private RolDAO rdao;
	
	@Inject
	private DocenteRolDAO rdDao;
	public void guardar(Docente d) {
		dao.save(d);
	}
	public void guardarDocenteRol(DocenteRol d) {
		rdDao.save(d);
	}

	public List<Docente> getListaDocentes() {
		return dao.getDocentes();
	}

	public Docente getDocente(int id) {
		Docente d = dao.getDocente(id);
		return d;
	}
	public Rol getRol(int codigo) {
		return rdao.read(codigo);
	}
	public Rol getRolCodigo(int nombreRol) {
		return rdao.read(nombreRol);
	}
	
	public List<Rol> getRoles(){
		return rdao.getRoles();
	}

	public void borra(int codigo) throws Exception {
		try {
			dao.delete(codigo);
		} catch (Exception e) {
			throw new Exception("Error al borrar " + e.getMessage());
		}

	}
	public Rol buscarRol(int codigo) throws Exception {
		try {
			Rol a = rdao.read(codigo);
			return a;
		}catch(Exception e) {
			throw new Exception("Código no corresponde");
		}
	}
//	public boolean docenteLogin(Docente d)  throws Exception {
//		boolean bandera=false;
//		Docente doc=null;
//		try {
//			doc=dao.getUsuarioDocente(d);
//			if(doc!=null) {
//				bandera =true;
//			}else {
//				bandera=false;
//			}
//			
//		} catch (Exception e) {
//			throw e;
//		}
//		return bandera;
//	}
	
	public Docente docenteLogin(String us,String pas)  throws Exception {
//	boolean bandera=false;
	Docente doc=null;
	try {
		doc=dao.getUsuarioDocente(us,pas);
		
//		if(doc!=null) {
//			bandera =true;
//		}else {
//			bandera=false;
//		}
		
	} catch (Exception e) {
		throw e;
	}
	return doc;
}
}
