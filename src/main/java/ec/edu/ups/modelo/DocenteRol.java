package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class DocenteRol {
	@Id
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name="docente_codigo")
	private Docente docente;
	@ManyToOne
	@JoinColumn(name="rol_codigo")
	private Rol rol;
	
	@Transient
	private int codigoTemRol;
	@Transient
	private String nombreTemRol;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Docente getDocente() {
		return docente;
	}
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public int getCodigoTemRol() {
		return codigoTemRol;
	}
	public void setCodigoTemRol(int codigoTemRol) {
		this.codigoTemRol = codigoTemRol;
	}
	public String getNombreTemRol() {
		return nombreTemRol;
	}
	public void setNombreTemRol(String nombreTemRol) {
		this.nombreTemRol = nombreTemRol;
	}
	
	
}
