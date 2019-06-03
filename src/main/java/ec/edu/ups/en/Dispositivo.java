package ec.edu.ups.en;

import java.util.Date;
/**
 * Clase Dispositivo con 5 atributos para obtener y manipular los datos del dispositivo
 * @author angel
 *
 */
public class Dispositivo {
	private int id;
	private String serie;
	private Date ultimaConexion;
	private GeoLocalizacion geo;
	private Usuario usuario;
	
	/**
	 * Medodo Constructor
	 */
	public Dispositivo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Date getUltimaConexion() {
		return ultimaConexion;
	}

	public void setUltimaConexion(Date ultimaConexion) {
		this.ultimaConexion = ultimaConexion;
	}

	public GeoLocalizacion getGeo() {
		return geo;
	}

	public void setGeo(GeoLocalizacion geo) {
		this.geo = geo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
