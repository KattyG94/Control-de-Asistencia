package ec.edu.ups.fachadaNegocio;

public class AlumnoNombreApellido {
	private String nombre;
	private String apellido;
	public AlumnoNombreApellido(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
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
	

}
