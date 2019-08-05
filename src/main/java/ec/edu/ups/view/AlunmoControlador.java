package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Alumno;
import ec.edu.ups.on.AlumnoON;
import ec.edu.ups.utils.VaidarCedula;

@ManagedBean
@ViewScoped
public class AlunmoControlador {
 
	private Alumno alumno;
	private List<Alumno> listaAlumnos;
	private FacesMessages facesMsg;
	private VaidarCedula vailidar;
	

	@Inject
	private AlumnoON alON;

	private int id;

	@Inject
	private FacesContext fc;

	@PostConstruct
	public void init() {
		alumno = new Alumno();
		vailidar=new VaidarCedula();
		listaAlumnos = alON.getAlumnos();
		facesMsg=new FacesMessages();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			alumno = alON.getAlumno(id);
		}
	}

	public void mostrarData(int ida) {
		if (ida == 0) {
			return;
		} else {
			alumno = alON.getAlumno(ida);
		}
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public String cargarDatos() {
		try {
			if(vailidar.validarCed(alumno.getCedula())) {
				alON.guardar(alumno);
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
		return "Alumnos?faces-redirect=true&id=" + id;
	}

	public String borrar(int codigo) {
		try {
			alON.borra(codigo);
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
		alumno = new Alumno();
		return null;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

}
