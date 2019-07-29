package ec.edu.ups.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
@Entity
public class Periodo {
	@Id
	@GeneratedValue
	private int id;
	private String periodo;
	@NotNull
	private Date inicio;
	@NotNull
	private Date fin;
//	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
//	private List<Asignatura> asignaturas;
	
	@OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Grupo> grupos;
	
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
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public List<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
	@Override
	public String toString() {
		return "Periodo [id=" + id + ", periodo=" + periodo + ", inicio=" + inicio + ", fin=" + fin + ", grupos="
				+ grupos + "]";
	}


	

}
