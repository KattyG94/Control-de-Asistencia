package bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import DAO.AlumnoDAO;
import modelos.Alumno;

@Stateless

public class AlumnoBussiness {

	@Inject
	private AlumnoDAO adao;
	
	public void save(Alumno alumno) throws Exception {
		Alumno aux= adao.read(alumno.getId());
		if (aux != null) {
			throw new Exception ("Alumno ya registrado");
		}  else {
			adao.insert(alumno);
		}
	}
	
	public List<Alumno> getListadoAlumno(){
		return adao.getAlumnos();
	}
	
	public void eliminar(int id) throws Exception{
		Alumno aux=adao.read(id);
		if (aux == null) {
			throw new Exception("Alumno no registrado");
		} else {
			adao.remove(id);
		}
	}
	
	public void actualizar(Alumno alumno) throws Exception {
		Alumno aux=adao.read(alumno.getId());
		if (aux == null) {
			throw new Exception("Alumno no registrado");
		} else {
			adao.update(alumno);
		}
	}
	
	public Alumno getAlum(int id) throws Exception{
		Alumno aux=adao.read(id);
		if (aux == null) {
			throw new Exception("Alumno no existe");
		}else {
			return aux;
		}
	}
	
	public boolean validarCed(String cedula) {
		boolean cedulaCorrecta = false;

		try {

			if (cedula.length() == 10) // ConstantesApp.LongitudCedula
			{
				int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
				if (tercerDigito < 6) {

					int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					int verificador = Integer.parseInt(cedula.substring(9, 10));
					int suma = 0;
					int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
						digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}

					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
						cedulaCorrecta = true;
					} else if ((10 - (suma % 10)) == verificador) {
						cedulaCorrecta = true;
					} else {
						cedulaCorrecta = false;
					}
				} else {
					cedulaCorrecta = false;
				}
			} else {
				cedulaCorrecta = false;
			}
		} catch (NumberFormatException nfe) {
			cedulaCorrecta = false;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrio en el proceso de validadcion");
			cedulaCorrecta = false;
		}

		if (!cedulaCorrecta) {
			System.out.println("La Cédula ingresada es Incorrecta");
		}
		return cedulaCorrecta;
	}
	
	public Alumno buscar(int id) {
		return adao.bAlumno(id);
	}
}
