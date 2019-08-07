package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Encuesta;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.modelo.Opcion;
import ec.edu.ups.modelo.Silabo;
import ec.edu.ups.on.EncuestaON;
import ec.edu.ups.on.GrupoON;

@ManagedBean
@ViewScoped
public class EncuestaControler {

	private Encuesta encuesta;
	private int id;
	private Grupo grupo;
	private List<Encuesta> listaEncuesta;
	private List<Grupo> grupos;
	@Inject
	private EncuestaON encuestaON;
	@Inject
	private GrupoON grupoON;
	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		encuesta = new Encuesta();
		grupo = new Grupo();
		encuesta.addOpciones(new Opcion());
		listaEncuesta = encuestaON.getEncuesta();
		grupos = grupoON.getGrupos();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			encuesta = encuestaON.getEncuesta(id);
			encuesta.getOpciones().size();
			System.out.println(encuesta.getPregunta());
			System.out.println(encuesta.getOpciones().size());
			for (Opcion op : encuesta.getOpciones()) {
				System.out.println("\t" + op);
			}
		}
	}

	public String registrarEncuesta() {
		try {
			encuesta.setGrupo_encuesta(grupo);
			encuestaON.guardar(encuesta);
			init();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}
		return null;
	}

	public String editar(int id) {
		return "Encuestas?faces-redirect=true&id=" + id;
	}

	public void nuevo() {
		encuesta = new Encuesta();
	}

	public String borrar(int codigo) {
		try {
			encuestaON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public void addOpciones() {
		encuesta.addOpciones(new Opcion());
	}

	public void elegirGrupo() {
		try {
			System.out.println(grupo.toString());
			grupo = grupoON.getGrupo(grupo);
			System.out.println("Hola amigos "+grupo.getId());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Encuesta getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(Encuesta encuesta) {
		this.encuesta = encuesta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Encuesta> getListaEncuesta() {
		return listaEncuesta;
	}

	public void setListaEncuesta(List<Encuesta> listaEncuesta) {
		this.listaEncuesta = listaEncuesta;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
