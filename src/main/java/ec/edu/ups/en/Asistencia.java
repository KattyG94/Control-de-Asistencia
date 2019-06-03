package ec.edu.ups.en;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Clase asistencia que contiene 5 atributos para el registro de asistencia y el control respectivo
 * @author angel
 *
 */
public class Asistencia {
	private int id;
	private Date fecha;
	private String observacion;
	private boolean estado;
	private List<Grupo> listaGrupo;
	
	public Asistencia() {
		// TODO Auto-generated constructor stub
		listaGrupo=new ArrayList<>();
	}
	/**
	 * Metodo que permite retornar el identificador de asistencia
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * Metodo que permite setear el valor del id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodo que perite retornar una fecha de tipo Date
	 * @return
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Metodo que permite enviar una fecha por parametro
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * Metodo de tipo String que permite retornar la observación
	 * @return
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * Metodo que permite enviar una observacion como parametro
	 * @param observacion
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * Metodo que permite retornar el estado de un estudiante
	 * Retorna un estado de verdadero si el estudiante esta presente en el Aula o Falso si el estudiante no esta presente
	 * @return
	 */
	public boolean isEstado() {
		return estado;
	}
	/**
	 * Metodo que permite enviar un valor booleano del estado del Alumno
	 * @param estado
	 */
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/**
	 * Metodo de tipo Lista que permite listar los grupos con cada objeto de las clases correspondientes
	 * @return
	 */
	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}
	/**
	 * Metodo que permite crear una istancia de la clase Grupos
	 * @param id
	 * @param codigo
	 * @param numero
	 * @param descripcion
	 * @param matricula
	 */
	public void setListaGrupo(int id, String codigo, String numero, String descripcion,
			Matricula matricula) {
		this.listaGrupo.add(new Grupo(id, codigo, numero, descripcion, matricula));
	}
	
	
	
}
