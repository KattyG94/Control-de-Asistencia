package ec.edu.ups.fachadaNegocio;

public class DocenteLogin {
	private String correo;
	private String contasenia;
	public String getCorreo() {
		return correo;
	}
	public DocenteLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public DocenteLogin(String correo, String contasenia) {
		this.correo = correo;
		this.contasenia = contasenia;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContasenia() {
		return contasenia;
	}
	public void setContasenia(String contasenia) {
		this.contasenia = contasenia;
	}
	
	

}
