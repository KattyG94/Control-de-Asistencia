package ec.edu.ups.view;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.modelo.Docente;

@Named
@ViewScoped
public class PlantillaControler implements Serializable{

	public void verificarSesion() {
		try {
			FacesContext context=FacesContext.getCurrentInstance();
			Docente doc=(Docente) context.getExternalContext().getSessionMap().get("usuario");
			if(doc==null) {
				context.getExternalContext().redirect("index.xhtml");
			}
		} catch (Exception e) {
			
		}
	}
}
