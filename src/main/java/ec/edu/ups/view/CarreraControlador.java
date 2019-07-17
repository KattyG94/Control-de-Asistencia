package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ec.edu.ups.modelo.Carrera;
import ec.edu.ups.on.CarreraON;

@ManagedBean
public class CarreraControlador {

	private Carrera carrera = new Carrera();
	private List<Carrera> listaCarreras;

	@Inject
	private CarreraON carreraON;

	private int id;

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public List<Carrera> getListaCarreras() {
		return listaCarreras;
	}

	public void setListaCarreras(List<Carrera> listaCarreras) {
		this.listaCarreras = listaCarreras;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@PostConstruct
	public void init() {
		carrera = new Carrera();
		listaCarreras = carreraON.getListaCarreras();
	}

	public void loadData() {
		if (id == 0) {
			return;
		} else {
			carrera = carreraON.getCarrera(id);
		}
	}

	public void mostrarData(int ids) {
		if (ids == 0) {
			return;
		} else {
			carrera = carreraON.getCarrera(ids);
		}
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
	
	public String borrar(int id) {
		try {
			carreraON.borrar(id);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public String listadoCarreras() {
		return "ListarCarreras";
	}
	
	public String nuevo() {
		carrera = new Carrera();
		return "Carrera";
	}
	
	public String redirectCarrera() {
		return "Carrera";
	}

}