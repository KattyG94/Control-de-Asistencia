package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.on.GrupoON;


@ManagedBean
@ViewScoped
public class GrupoController {
private Grupo grupo;
	
	private int id;
	
	private List<Grupo>listaGrupo;
	@Inject
	private GrupoON gruoON;
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		grupo=new Grupo();
		listaGrupo=gruoON.getGrupos();
		
		
	}
	public void loadData() {
		if (id == 0)
			return;
		grupo = gruoON.getGrupo(id);
	}
	public String registrarPerido() {
		try {
			gruoON.guardarGrupo(grupo);
			init();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}
		return null;
	}
	public String editar(int id) {
		return "Grupos?faces-redirect=true&id=" + id;
	}
	
	public void nuevo() {
		grupo  =new Grupo();
	}
	public String borrar(int codigo) {
		try {
			gruoON.eliminarGrupo(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	

	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public List<Grupo> getListaPeriodos() {
		return listaGrupo;
	}
	public void setListaPeriodos(List<Grupo> listaGrupos) {
		this.listaGrupo = listaGrupos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
