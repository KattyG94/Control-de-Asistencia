package ec.edu.ups.modelo;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


@Table(uniqueConstraints = @UniqueConstraint(columnNames = "cedula"))
@MappedSuperclass
public class Usuario {
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 1, max = 10)
	@Column(unique = true)
	private String cedula;
	@NotNull
	@NotEmpty
	private String nombres;
	@NotNull
	@NotEmpty
	private String apellidos;
	@NotNull
	private Date fechaNac;
	@NotNull
	@NotEmpty
	private String genero;
	@NotNull
	@NotEmpty
	private String telefono;
	@NotNull
	@NotEmpty
	private String direccion;
	@Column(unique = true)
	@NotNull
	@NotEmpty
	private String correo;
	@NotNull
	@NotEmpty
	private String contrasena;
	private double latitud;
	private double longitud;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", fechaNac=" + fechaNac + ", genero=" + genero + ", telefono=" + telefono + ", direccion="
				+ direccion + ", correo=" + correo + ", contrasena=" + contrasena + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}
	
	

}
