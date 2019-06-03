package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Asistencia {
	private int id;
	private Date fecha;
	private String observacion;
	private boolean estado;
	private List<Grupo> listaGrupo;
	
	public Asistencia() {
		// TODO Auto-generated constructor stub
		listaGrupo=new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(int id, String codigo, String numero, String descripcion,
			Matricula matricula) {
		this.listaGrupo.add(new Grupo(id, codigo, numero, descripcion, matricula));
	}
	
	
	
}
