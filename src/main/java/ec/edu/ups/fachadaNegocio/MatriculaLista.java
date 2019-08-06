package ec.edu.ups.fachadaNegocio;

public class MatriculaLista {
	private int codMatricula;
	private int codGrupo;
	private int codAlumno;
	public MatriculaLista(int codMatricula, int codGrupo, int codAlumno) {
		this.codMatricula = codMatricula;
		this.codGrupo = codGrupo;
		this.codAlumno = codAlumno;
	}
	public int getCodMatricula() {
		return codMatricula;
	}
	public void setCodMatricula(int codMatricula) {
		this.codMatricula = codMatricula;
	}
	public int getCodGrupo() {
		return codGrupo;
	}
	public void setCodGrupo(int codGrupo) {
		this.codGrupo = codGrupo;
	}
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	

}
