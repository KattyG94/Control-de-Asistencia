package ec.edu.ups.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Asistencia;
import ec.edu.ups.modelo.Grupo;
import ec.edu.ups.on.AsistenciaON;
import ec.edu.ups.on.GrupoON;


@ManagedBean
@ViewScoped
public class AsistenciaControler {
	
	private String fecha;
	private int codigoGrupo;
	private List<Asistencia> listaAsistencia;
	private List<Grupo> grupos;
	private FacesMessages mesage;
	@Inject
	private GrupoON grupoON;
	
	@Inject
	private AsistenciaON asistenciaOn;
	

	@PostConstruct
	public void init() {
		//listaAsistencia=new ArrayList<Asistencia>();
		//listaAsistencia=asistenciaOn.getAsistencia();
		grupos=grupoON.getGrupos();
		mesage=new FacesMessages();
		
	}
	public void verificar() {

		listaAsistencia=asistenciaOn.getListadoAsistencia(fecha,codigoGrupo);
		System.out.println(listaAsistencia.size());
		if(listaAsistencia.size()==0){
			mesage.warningMessage("No existe registro");
			}
			
		}
	

//	public List<Asistencia> listaAsistencia(){
//		List<Asistencia> lista=asistenciaOn.getListadoAsistencia(asistencia.getFecha(), asistencia.getGrupo().getId());
//		return lista;
//	}
	
	public List<Asistencia> getListaAsistencia() {
		return listaAsistencia;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodigoGrupo() {
		return codigoGrupo;
	}
	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	public void setListaAsistencia(List<Asistencia> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}
