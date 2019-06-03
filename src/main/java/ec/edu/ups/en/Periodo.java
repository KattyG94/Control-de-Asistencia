package ec.edu.ups.en;

import java.util.Date;

public class Periodo {
private int id;
private String codigo;
private Date inicio;
private Date fin;
private boolean estado;

public Periodo() {
	// TODO Auto-generated constructor stub
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
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

public boolean isEstado() {
	return estado;
}

public void setEstado(boolean estado) {
	this.estado = estado;
}


}
