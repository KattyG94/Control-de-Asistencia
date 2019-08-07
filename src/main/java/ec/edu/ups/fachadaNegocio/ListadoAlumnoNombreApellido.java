package ec.edu.ups.fachadaNegocio;

public class ListadoAlumnoNombreApellido {
	
	private int codMatricula;
	private String nombre;
	private String apellido;
	private int id;
	
	
	public ListadoAlumnoNombreApellido(int codMatricula, String nombre, String apellido, int id) {
		this.codMatricula = codMatricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.id=id;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
