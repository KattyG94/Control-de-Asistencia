package ec.edu.ups.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Docente;
import ec.edu.ups.on.DocenteON;

@ManagedBean
@SessionScoped
public class LoginControler {
	private Docente docente;
	private String nombreUsuario;
	private FacesMessages facesMsg;

	@Inject
	private DocenteON dON;


	@PostConstruct
	public void init() {
		docente=new Docente();
		facesMsg=new FacesMessages();
	}

	public String iniciarSesion(){
		boolean doc=false;
		
		String redireccion=null;
		try {
			Docente docenete=dON.docenteLogin1(docente.getCorreo(),docente.getContrasena());
			if (docenete!=null) {
				doc=true;
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", doc);
				setNombreUsuario(docenete.getNombres()+" "+docenete.getApellidos());
				redireccion="Sistema";
			}else{
				facesMsg.errorMessage("Usuario o clave incorrecta");
			}
		} catch (Exception e) {
			facesMsg.errorMessage("Usuario o clave incorrecta");
		}
		return redireccion;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}


}
