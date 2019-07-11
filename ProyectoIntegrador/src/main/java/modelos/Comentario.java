//package modelos;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Comentario {
//	@Id
//	private int codigo;
//	@OneToOne
//	@JoinColumn(name="alumno_codigo")
//	private Alumno alumno;
//	@OneToOne
//	@JoinColumn(name="docente_codigo")
//	private Docente docente;
//	private String contenido;
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
//	public Alumno getAlumno() {
//		return alumno;
//	}
//	public void setAlumno(Alumno alumno) {
//		this.alumno = alumno;
//	}
//	public Docente getDocente() {
//		return docente;
//	}
//	public void setDocente(Docente docente) {
//		this.docente = docente;
//	}
//	public String getContenido() {
//		return contenido;
//	}
//	public void setContenido(String contenido) {
//		this.contenido = contenido;
//	}
//	
//	
//	
//	
//	
//}
