package ec.edu.ups.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import ec.edu.ups.modelo.Docente;

@Named
@SessionScoped
public class PlantillaControler implements Serializable{

	private String nombre;
	private static final long serialVersionUID = 1L;
	
	public void verificarSesion() {
		try {
			FacesContext context=FacesContext.getCurrentInstance();
			Docente doc=(Docente) context.getExternalContext().getSessionMap().get("usuario");
			if(doc!=null) {
				nombre=doc.getNombres();
			}else {
				context.getExternalContext().redirect("index.xhtml");
			}
		} catch (Exception e) {
			
		}
	}
	public void serrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
