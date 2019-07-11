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
//public class Asistencia {
//	
//	@Id
//	private int codigo;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "tema_codigo")
//	private List<Tema> temas;
//	@OneToOne
//	@JoinColumn(name="grupo_codigo")
//	private Grupo grupo;
//	
//	public int getCodigo() {
//		return codigo;
//	}
//	public void setCodigo(int codigo) {
//		this.codigo = codigo;
//	}
//	public List<Tema> getTemas() {
//		return temas;
//	}
//	public void setTemas(List<Tema> temas) {
//		this.temas = temas;
//	}
//	
//	
//	
//
//}
