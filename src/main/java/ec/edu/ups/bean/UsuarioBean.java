package ec.edu.ups.bean;

import javax.faces.bean.ManagedBean;

import ec.edu.ups.en.Usuario;

@ManagedBean
public class UsuarioBean {
private Usuario usuario;

public UsuarioBean() {
	// TODO Auto-generated constructor stub
	usuario=new Usuario();
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

}
