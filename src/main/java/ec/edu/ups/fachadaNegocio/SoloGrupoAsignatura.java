package ec.edu.ups.fachadaNegocio;

public class SoloGrupoAsignatura {
	private int codigoGrupo;
	private int numero;
	private String asignatura;
	
	public SoloGrupoAsignatura(int codigoGrupo, int numero, String asignatura) {
		this.codigoGrupo = codigoGrupo;
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
	public int getCodigoGrupo() {
		return codigoGrupo;
	}
	public void setCodigoGrupo(int codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	
	

}
