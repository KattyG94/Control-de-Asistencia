package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.modelo.Asistencia;
import ec.edu.ups.on.AsistenciaON;
@ManagedBean
@ViewScoped
public class AsistenciaControler {
	
	private Asistencia asistencia;
	private List<Asistencia> listaAsistencia;
	
	@Inject
	private AsistenciaON asistenciaOn;
	

	@PostConstruct
	public void init() {
		asistencia=new Asistencia();
		listaAsistencia=asistenciaOn.getAsistencia();
		
	}
//	public List<Asistencia> listaAsistencia(){
//		List<Asistencia> lista=asistenciaOn.getListadoAsistencia(asistencia.getFecha(), asistencia.getGrupo().getId());
//		return lista;
//	}
	public Asistencia getAsistencia() {
		return asistencia;
	}
	public void setAsistencia(Asistencia asistencia) {
		this.asistencia = asistencia;
	}
	public List<Asistencia> getListaAsistencia() {
		return listaAsistencia;
	}
	public void setListaAsistencia(List<Asistencia> listaAsistencia) {
		this.listaAsistencia = listaAsistencia;
	}
	
}
