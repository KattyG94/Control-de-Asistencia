package ec.edu.ups.en;

public class Encuesta {
	private int id;
	private String concepto;
	private String descripcion;
	private Grupo grupo;
	
	public Encuesta() {
		// TODO Auto-generated constructor stub
	}

	public Encuesta(int id, String concepto, String descripcion, Grupo grupo) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.descripcion = descripcion;
		this.grupo = grupo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
