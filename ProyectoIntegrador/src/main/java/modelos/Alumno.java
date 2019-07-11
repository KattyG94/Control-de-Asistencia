//package modelos;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Alumno {
//	
//	@Id //Clave primaria
//	private int codigo;
//	private String nombres;
//	private String apellidos;
//	@OneToOne
//	@JoinColumn(name="grupo_codigo")
//	private Grupo grupo;
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
//	public Grupo getGrupo() {
//		return grupo;
//	}
//	public void setGrupo(Grupo grupo) {
//		this.grupo = grupo;
//	}
//	
//	
//	
//
//}
