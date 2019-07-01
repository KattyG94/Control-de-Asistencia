package ec.edu.ups.modelo;

import java.util.Date;

import javax.persistence.Column;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Persona {

	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Column(name = "apellido")
	private String apellido;

	@NotNull
//	@Column(name = "cedula", length = 10)
	private String cedula;

	@NotNull
	@Column(name = "fechaNacimiento")
	private Date fechaNac;

	@NotNull
//	@Column(name = "sexo", length = 2)
	private String sexo;

	@NotNull
//	@Column(name = "telefono",length = 10)
	private String telefono;

	@NotNull
//	@Size(min = 1, max = 80)
	@Column(name = "direccion")
	private String direccion;


	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", fechaNac=" + fechaNac
				+ ", sexo=" + sexo + ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

}
