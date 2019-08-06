package ec.edu.ups.fachadaNegocio;

public class ListadoAlumnoNombreApellido {
	
	private int codMatricula;
	private String nombre;
	private String apellido;
	
	
	public ListadoAlumnoNombreApellido(int codMatricula, String nombre, String apellido) {
		this.codMatricula = codMatricula;
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
	public int getCodMatricula() {
		return codMatricula;
	}
	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}
	
	

}
