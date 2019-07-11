//package modelos;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Grupo {
//	
//	@Id
//	private int codigo;
//	@OneToOne
//	@JoinColumn(name="docente_codigo")
//	private Docente docente;
//	@OneToMany( cascade = CascadeType.ALL)
//	@JoinColumn(name = "alumno_codigo")
//	private List<Alumno> alumnos;
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
//	public Docente getDocente() {
//		return docente;
//	}
//	public void setDocente(Docente docente) {
//		this.docente = docente;
//	}
//	public List<Alumno> getAlumnos() {
//		return alumnos;
//	}
//	public void setAlumnos(List<Alumno> alumnos) {
//		this.alumnos = alumnos;
//	}
//
//	
//	
//	
//
//}
