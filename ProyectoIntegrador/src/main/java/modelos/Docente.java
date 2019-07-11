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
//
//@Entity
//public class Docente {
//	
//	@Id //Clave primaria
//	private int codigo;
//	private String nombres;
//	private String apellidos;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "materia_codigo")
//	private List<Materia> materias;
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
//	public String getNombres() {
//		return nombres;
//	}
//	public void setNombres(String nombres) {
//		this.nombres = nombres;
//	}
//	public String getApellidos() {
//		return apellidos;
//	}
//	public void setApellidos(String apellidos) {
//		this.apellidos = apellidos;
//	}
//	public List<Materia> getMaterias() {
//		return materias;
//	}
//	public void setMaterias(List<Materia> materias) {
//		this.materias = materias;
//	}
//	
//	
//
//}
