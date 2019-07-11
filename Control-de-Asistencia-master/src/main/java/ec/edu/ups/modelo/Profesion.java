package ec.edu.ups.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profesion {
	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	
	public Profesion() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Profesion [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
