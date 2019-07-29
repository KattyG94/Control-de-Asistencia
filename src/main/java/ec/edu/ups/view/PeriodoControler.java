package ec.edu.ups.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.modelo.Periodo;
import ec.edu.ups.on.PeriodoON;

@ManagedBean
@ViewScoped
public class PeriodoControler {
	
	private Periodo periodo;
	
	private int id;
	
	private List<Periodo>listaPeriodos;
	@Inject
	private PeriodoON peridoON;
	@Inject
	private FacesContext fc;
	
	@PostConstruct
	public void init() {
		periodo=new Periodo();
		listaPeriodos=peridoON.getPeriodos();
		
		
	}
	public void loadData() {
		if (id == 0)
			return;
		periodo = peridoON.getPeriod(id);
	}
	public String registrarPerido() {
		try {
			peridoON.guardarPeriodo(periodo);
			init();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), "Error");
			fc.addMessage(null, msg);
		}
		return null;
	}
	public String editar(int id) {
		return "Periodos?faces-redirect=true&id=" + id;
	}
	
	public void nuevo() {
		periodo  =new Periodo();
	}
	public String borrar(int codigo) {
		try {
			peridoON.eliminarPeriodo(codigo);
			init();
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	public List<Periodo> getListaPeriodos() {
		return listaPeriodos;
	}
	public void setListaPeriodos(List<Periodo> listaPeriodos) {
		this.listaPeriodos = listaPeriodos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
