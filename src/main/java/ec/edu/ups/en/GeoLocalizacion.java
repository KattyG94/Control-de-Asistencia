package ec.edu.ups.en;

import java.util.Date;

/**
 * Clase Geolocalizacion que permite obtener y manipular los datos de la localizacion
 * @author angel
 *
 */
public class GeoLocalizacion {
	private int id;
	private Double latitud;
	private Double longitud;
	private Date fecha;

	public GeoLocalizacion() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
