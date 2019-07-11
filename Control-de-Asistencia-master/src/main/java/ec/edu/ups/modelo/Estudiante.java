package ec.edu.ups.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tbl_Estudiantes", uniqueConstraints=@UniqueConstraint(columnNames="cedula"))
public class Estudiante extends Persona {
		
		@Id
		@Column(name="cedula")
		@Size(min=1, max=10)
		private String cedula;

	
		@NotNull
		@NotEmpty
		private String usuario;
		@NotNull
		@NotEmpty
		private String clave;
		
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
}