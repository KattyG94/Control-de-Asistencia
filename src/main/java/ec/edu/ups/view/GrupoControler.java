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

import ec.edu.ups.modelo.Asignatura;
import ec.edu.ups.modelo.Carrera;
import ec.edu.ups.modelo.Docente;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.modelo.Periodo;
import ec.edu.ups.on.AsingnaturaON;
import ec.edu.ups.on.CarreraON;
import ec.edu.ups.on.DocenteON;
import ec.edu.ups.on.GrupoON;
import ec.edu.ups.on.PeriodoON;

@ManagedBean
@ViewScoped
public class GrupoControler {
	private Grupo grupo;
	private Docente docente;
	private Carrera carrera;
	private Asignatura asignatura;
	private Periodo periodo;

	private int id;

	private List<Grupo> listaGrupo;
	private List<SelectItem> selectOneItemRol;
	private List<Carrera> listaCarrera;
	private List<Asignatura> listaAsignatura;
	private List<Periodo> listaPeriodo;
	@Inject
	private GrupoON gruoON;
	@Inject
	private DocenteON docenteON;
	@Inject
	private CarreraON carreraON;
	@Inject
	private AsingnaturaON asignaturaON;
	@Inject
	private PeriodoON periodoON;
	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		grupo = new Grupo();
		docente = new Docente();
		carrera = new Carrera();
		asignatura = new Asignatura();
		periodo=new Periodo();

		listaCarrera = carreraON.getCarreras();
		listaAsignatura = asignaturaON.getAsignatura();
		listaPeriodo=periodoON.getPeriodos();
		listaGrupo=gruoON.getGrupos();

	}

	public void loadData() {
		if (id == 0)
			return;
		grupo = gruoON.getGrupo(id);
	}

	public String registrarGrupo() {
		try {
			grupo.setPeriodo(periodo);
			grupo.setDocente(docente);
			grupo.setCarrera(carrera);
			grupo.setAsignatura(asignatura);
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
		grupo = new Grupo();
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

	public void consultarDocente() {

		List<Docente> docentes = docenteON.getListaDocentes();
		for (Docente docente : docentes) {
			if (grupo.getDocenteIdTemp() == docente.getId())
				grupo.setDocente(docente);
			System.out.println(docente.toString());
		}

	}

	public void buscarDocenteCedula() {
		try {
			docente = docenteON.getDocenteCedula(docente);
			System.out.println(docente.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void elegirPeriodo() {
		try {
			periodo = periodoON.getPeriod(periodo.getId());
			System.out.println(periodo.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<SelectItem> getSelectOneItemCarrera() {
		this.selectOneItemRol = new ArrayList<>();
		List<Carrera> carreras = listaCarrera;
		for (Carrera carrera : carreras) {
			SelectItem selectItem = new SelectItem(carrera.getId(), carrera.getNombre());
			this.selectOneItemRol.add(selectItem);
		}
		return selectOneItemRol;
	}

	public void elegirCarrera() {
		carrera = carreraON.getCarrera(carrera.getId());
		System.out.println(carrera.toString());
	}

	public void elegirAsignatura() {
		asignatura = asignaturaON.getAsignatura(asignatura.getId());
		System.out.println(asignatura.toString());
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

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Carrera> getListaCarrera() {
		return listaCarrera;
	}

	public void setListaCarrera(List<Carrera> listaCarrera) {
		this.listaCarrera = listaCarrera;
	}

	public List<SelectItem> getSelectOneItemRol() {
		return selectOneItemRol;
	}

	public void setSelectOneItemRol(List<SelectItem> selectOneItemRol) {
		this.selectOneItemRol = selectOneItemRol;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<Asignatura> getListaAsignatura() {
		return listaAsignatura;
	}

	public void setListaAsignatura(List<Asignatura> listaAsignatura) {
		this.listaAsignatura = listaAsignatura;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Periodo> getListaPeriodo() {
		return listaPeriodo;
	}

	public void setListaPeriodo(List<Periodo> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}

}
