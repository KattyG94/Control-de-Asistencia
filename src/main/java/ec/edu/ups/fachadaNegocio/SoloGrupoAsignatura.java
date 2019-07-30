package ec.edu.ups.fachadaNegocio;

public class SoloGrupoAsignatura {
	private int numero;
	private String asignatura;
	public SoloGrupoAsignatura(int numero, String asignatura) {
		super();
		this.numero = numero;
		this.asignatura = asignatura;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	

}
