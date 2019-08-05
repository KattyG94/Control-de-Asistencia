    
package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.DocenteRol;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.on.DocenteON;
import ec.edu.ups.utils.VaidarCedula;

@ManagedBean
@ViewScoped
public class DocenteControlador {

	private Docente docente;
	private List<Docente> listaDocente;
	private FacesMessages facesMsg;
	private VaidarCedula vailidar;

	@Inject
	private DocenteON dON;

	private int id;
	
	private int idRolTemp;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		docente=new Docente();
		vailidar=new VaidarCedula();
		listaDocente=dON.getListaDocentes();
		facesMsg=new FacesMessages();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			docente = dON.getDocente(id);
		}
		
	}

	public void mostrarData(int ids) {
		if (ids == 0)
			return;
		docente = dON.getDocente(ids);
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Docente getDocente() {
		return docente;
	}

	public String cargarDatos() {
		try {
			if(vailidar.validarCed(docente.getCedula())) {
				dON.guardar(docente);
				facesMsg.infoMessage("Datos guardado correctamente");
				init();
			}else {
				facesMsg.errorMessage("La Cédula ingresada es Incorrecta");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String editar(int id) {
		return "Docentes?faces-redirect=true&id="+ id;
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
