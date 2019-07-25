package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Carrera;
import ec.edu.ups.on.CarreraON;

@ManagedBean
@ViewScoped
public class CarreraControlador {

	private Carrera carrera;
	private List<Carrera> listaCarreras;

	@Inject
	private CarreraON carreraON;

	private int id;

	@PostConstruct
	public void init() {
		carrera = new Carrera();
		listaCarreras = carreraON.getCarreras();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			carrera = carreraON.getCarrera(id);
		}
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String cargarDatos() {
		try {
			carreraON.guardar(carrera);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String editar(int id) {
		return "Carreras?faces-redirect=true&id=" + id;
	}

	public String borrar(int codigo) {
		try {
			carreraON.borra(codigo);
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
		carrera = new Carrera();
		return null;
	}

	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

}
