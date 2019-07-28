package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.on.DocenteON;
import ec.edu.ups.on.GrupoON;


@ManagedBean
@ViewScoped
public class GrupoControler {
private Grupo grupo;
private Docente docente;
	
	private int id;
	
	private List<Grupo>listaGrupo;
	@Inject
	private GrupoON gruoON;
	@Inject
	private DocenteON docenteON;
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		grupo=new Grupo();
		docente=new Docente();
//		listaGrupo=gruoON.getGrupos();
		
		
	}
	public void loadData() {
		if (id == 0)
			return;
		grupo = gruoON.getGrupo(id);
	}
	public String registrarGrupo() {
		try {
			System.out.println(grupo.toString());
			grupo.setDocente(docente);
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
	
	public void consultarDocente(){
		
		List<Docente> docentes =  docenteON.getListaDocentes();
		for(Docente docente: docentes) {
			if(grupo.getDocenteIdTemp()==docente.getId())
				grupo.setDocente(docente);
			System.out.println(docente.toString());
		}
		
	}
	public void buscarDocenteCedula(){
		
		docente =  docenteON.getDocenteCedula(docente.getCedula());
		
		System.out.println(docente.toString());
		
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}
	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}



}
