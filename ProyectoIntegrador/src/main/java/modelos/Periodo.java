package modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Periodo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String periodo;
	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
	private List<Asignatura> asignaturas;
	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getPeriodo() {
		return periodo;
	}



	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}



	@Override
	public String toString() {
		return "Periodo [id=" + id + ", periodo=" + periodo + "]";
	}
	
	

}
