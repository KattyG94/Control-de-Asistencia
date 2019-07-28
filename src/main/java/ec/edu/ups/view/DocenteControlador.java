    
package ec.edu.ups.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.on.DocenteON;

@ManagedBean
@ViewScoped
public class DocenteControlador {

	private Docente docente;
	private List<Docente> listaDocente;
//	private List<Rol>listaRoles;
	private List<SelectItem> selectOneItemRol;

	@Inject
	private DocenteON dON;

	private int id;
	
	private int idRolTemp;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		docente=new Docente();
		listaDocente=dON.getListaDocentes();
//		listaRoles=dON.getRoles();
	}

	public void loadData() {
		if (id == 0)
			return;
		docente = dON.getDocente(id);
		System.out.println("Estoy aqui");
		System.out.println(docente.toString());
	}

	public void mostrarData(int ids) {
		System.out.println("codigo editar " + ids);
		if (ids == 0)
			return;
		docente = dON.getDocente(ids);
		System.out.println("Estoy aqui");
		System.out.println(docente.toString());
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}

	public String cargarDatos() {
		try {
			dON.guardar(docente);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String editar(int id) {
		System.out.println("dddd  " + id);
		return "Docentes?faces-redirect=true&id=" + id;
	}

	public String borrar(int codigo) {
		try {
			dON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String listadoDocentes() {
		System.out.println("Hola");
		return "ListarDocente";

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String nuevo() {
		docente = new Docente();
		return null;
	}

	public String buscarRol(DocenteRol drol) {
		System.out.println("buscando Rol " + drol);
		try {
			Rol rol = dON.getRol(drol.getCodigoTemRol());
			drol.setRol(rol);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}

		return null;
	}

	
	
	public void setSelectOneItemRol(List<SelectItem> selectOneItemRol) {
		this.selectOneItemRol = selectOneItemRol;
	}

//	public List<SelectItem> getSelectOneItemRol(){
//		this.selectOneItemRol=new ArrayList<>();
//		List<Rol>roles=listaRoles;
//		for (Rol rol : roles) {
//			SelectItem selectItem=new SelectItem(rol.getCodigo(), rol.getNombreRol());
//			Rol rol1 = dON.getRol(this.getIdRolTemp());
//			DocenteRol drol=new DocenteRol();
//			drol.setRol(rol1);
//			this.selectOneItemRol.add(selectItem);
//		}
//		return selectOneItemRol;
//	}
	public String buscarRolCodigo(DocenteRol drol) {
		try {
			Rol rol = dON.getRol(drol.getCodigoTemRol());
			drol.setRol(rol);
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}

		return null;
	}

	public String addRol() {
		docente.addDocenteRol(new DocenteRol());
		return null;
	}

	public List<Docente> getListaDocente() {
		return listaDocente;
	}


//	public List<Rol> getListaRoles() {
//		return listaRoles;
//	}
//
//	public void setListaRoles(List<Rol> listaRoles) {
//		this.listaRoles = listaRoles;
//	}

	public int getIdRolTemp() {
		return idRolTemp;
	}
}
