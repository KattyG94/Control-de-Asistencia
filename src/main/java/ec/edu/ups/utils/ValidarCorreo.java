package ec.edu.ups.utils;

public class ValidarCorreo {
	public boolean validarCorreo(String correo) {
		boolean bandera = false;
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (correo.matches(regex)) {
			bandera=true;
		}else {
			bandera=false;
		}
		
		return bandera;
	}
}
