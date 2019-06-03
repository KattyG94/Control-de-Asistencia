package ec.edu.ups.en;
/**
 * Clase rol que permite manipular los roles que cada docente posee
 * @author angel
 *
 */
public class Rol {
	private int id;
	private String descripcion;
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", descripcion=" + descripcion + "]";
	}
	

}
