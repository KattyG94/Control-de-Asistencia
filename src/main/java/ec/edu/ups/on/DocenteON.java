package ec.edu.ups.on;

import java.util.List;

import javax.ejb.EJBException;
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
	private InstalacionRol dROL;

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

	public Docente getDocenteCedula(Docente docente) {
		Docente doc = dao.getDocenteDNI(docente);
		return doc;
	}

	public Docente getDocente(int id) {
		Docente d = dao.getDocente(id);
		return d;
	}

	public Rol getRol(int codigo) {
		return rdao.read(codigo);
	}
//	public Rol getRolCodigo(String nombreRol) {
//		return rdao.getRolCodigo(nombreRol);
//	}

	public List<Rol> getRoles() {
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
		} catch (Exception e) {
			throw new Exception("Código no corresponde");
		}
	}

	public Docente docenteLogin(String us, String pas) throws Exception {
		Docente doc = null;
		try {
				doc = dao.getUsuarioDocente(us, pas);
		} catch (Exception e) {
			throw e;
		}
		return doc;
	}
	public Docente docenteLogin1(String us, String pas) {
		Docente docv = null;
		try {
			docv = dao.getUsuarioDocente(us, pas);
			if(!docv.getRol().equals("Jefe de Area")) {
				docv=null;
			}
		} catch (java.lang.NullPointerException e) {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return docv;
	}

	public InstalacionRol getdROL() {
		return dROL;
	}

	public void setdROL(InstalacionRol dROL) {
		this.dROL = dROL;
	}
}
