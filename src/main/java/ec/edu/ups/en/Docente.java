package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona {
private int id;
private String prefesion;
private String nivelEstudio;
private int aniosExperiencia;
private List<Rol> rolLista;

public Docente() {
	// TODO Auto-generated constructor stub
	rolLista=new ArrayList<>();
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getPrefesion() {
	return prefesion;
}

public void setPrefesion(String prefesion) {
	this.prefesion = prefesion;
}

public String getNivelEstudio() {
	return nivelEstudio;
}

public void setNivelEstudio(String nivelEstudio) {
	this.nivelEstudio = nivelEstudio;
}

public int getAniosExperiencia() {
	return aniosExperiencia;
}

public void setAniosExperiencia(int aniosExperiencia) {
	this.aniosExperiencia = aniosExperiencia;
}

public List<Rol> getRolLista() {
	return rolLista;
}

public void setRolLista(Rol rolLista) {
	this.rolLista.add(rolLista);
}

}
