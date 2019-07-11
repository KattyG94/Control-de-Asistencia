//package modelos;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Materia {
//	
//	@Id
//	private int codigo;
//	private String nombre;
//	private int creditos;
//	@OneToOne
//	@JoinColumn(name="docente_codigo")
//	private Docente docente;
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	public int getCreditos() {
//		return creditos;
//	}
//	public void setCreditos(int creditos) {
//		this.creditos = creditos;
//	}
//	public Docente getDocente() {
//		return docente;
//	}
//	public void setDocente(Docente docente) {
//		this.docente = docente;
//	}
//	
//	
//
//}
