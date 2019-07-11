package view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import modelos.Tema;
import on.TemaON;

@ManagedBean
public class TemaController {

	private Tema tema = new Tema();
	private int codigo;
	private List<Tema> listadoTemas;
	
	private FacesContext fc;
	
	@Inject
	private TemaON tON;

	@PostConstruct
	public void init() {
		listadoTemas = tON.getListadoTemas();
	}

	

	public Tema getTema() {
		return tema;
	}



	public void setTema(Tema tema) {
		this.tema = tema;
	}



	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	



	public List<Tema> getListadoTemas() {
		return listadoTemas;
	}



	public void setListadoTemas(List<Tema> listadoTemas) {
		this.listadoTemas = listadoTemas;
	}



	public String cargarDatos() {
		try {
			tON.save(tema);
			init();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}
	
	public void loadDatos() {
		if(codigo==0)
			return;
		System.out.println("codigo editar " + this.codigo);
		tema = tON.getTema(this.codigo);
		
		if(tema == null) {
			tema= new Tema();
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Registro no existe", "Información");
			fc.addMessage(null, msg);
			
		}
			
		
		System.out.println(tema);
	}


	public String editar(int id) {
		tema = tON.getTema(id);
		System.out.println(tema.toString());
		return "Tema";
	}

	public String borrar(int codigo) {
		try {
			tON.borra(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
