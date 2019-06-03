package ec.edu.ups.en;

public class Asignatura {
	private int id;
	private String codigo;
	private String nombre;
	private String creditos;

	public Asignatura() {
		// TODO Auto-generated constructor stub
	}

	public Asignatura(int id, String codigo, String nombre, String creditos) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCreditos() {
		return creditos;
	}

	public void setCreditos(String creditos) {
		this.creditos = creditos;
	}

}
