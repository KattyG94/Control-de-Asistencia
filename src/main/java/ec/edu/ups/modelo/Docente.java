package ec.edu.ups.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Docente extends Persona{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
//	@NotNull
//	@Column(name = "nombre")
//	private String nombre;
//
//	@NotNull
//	@Column(name = "apellido")
//	private String apellido;
//
//	@NotNull
////	@Column(name = "cedula", length = 10)
//	private String cedula;
//
//	@NotNull
//	@Column(name = "fechaNacimiento")
//	private String fechaNac;
//
//	@NotNull
////	@Column(name = "sexo", length = 2)
//	private String sexo;
//
//	@NotNull
////	@Column(name = "telefono",length = 10)
//	private String telefono;
//
//	@NotNull
////	@Size(min = 1, max = 80)
//	@Column(name = "direccion")
//	private String direccion;
	
	@NotNull
//	@Size(min = 1, max = 30)
	@Column(name = "profesion")
	private String profesion;

	@NotNull
//	@Size(min = 1, max = 30)
	@Column(name = "nivelEstudio")
	private String nivelEstudio;

	@NotNull
//	@Size(min = 5, max = 30)
	@Column(name = "usuario")
	private String usuario;

	@NotNull
//	@Size(min = 5, max = 30)
	@Column(name = "clave")
	private String clave;
	


	public Docente() {

	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


//
//	public String getNombre() {
//		return nombre;
//	}
//
//
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//
//
//	public String getApellido() {
//		return apellido;
//	}
//
//
//
//	public void setApellido(String apellido) {
//		this.apellido = apellido;
//	}
//
//
//
//	public String getCedula() {
//		return cedula;
//	}
//
//
//
//	public void setCedula(String cedula) {
//		this.cedula = cedula;
//	}
//
//
//
//	public String getFechaNac() {
//		return fechaNac;
//	}
//
//
//
//	public void setFechaNac(String fechaNac) {
//		this.fechaNac = fechaNac;
//	}
//
//
//
//	public String getSexo() {
//		return sexo;
//	}
//
//
//
//	public void setSexo(String sexo) {
//		this.sexo = sexo;
//	}
//
//
//
//	public String getTelefono() {
//		return telefono;
//	}
//
//
//
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
//
//
//
//	public String getDireccion() {
//		return direccion;
//	}
//
//
//
//	public void setDireccion(String direccion) {
//		this.direccion = direccion;
//	}



	public String getProfesion() {
		return profesion;
	}



	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}



	public String getNivelEstudio() {
		return nivelEstudio;
	}



	public void setNivelEstudio(String nivelEstudio) {
		this.nivelEstudio = nivelEstudio;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	@Override
	public String toString() {
		return "Docente [id=" + id + ", profesion=" + profesion + ", nivelEstudio=" + nivelEstudio + ", usuario="
				+ usuario + ", clave=" + clave + "]";
	}



//	@Override
//	public String toString() {
//		return "Docente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
//				+ ", fechaNac=" + fechaNac + ", sexo=" + sexo + ", telefono=" + telefono + ", direccion=" + direccion
//				+ ", profesion=" + profesion + ", nivelEstudio=" + nivelEstudio + ", usuario=" + usuario + ", clave="
//				+ clave + "]";
//	}
//	
	
}
