package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.EstudianteDAO;
import ec.edu.ups.modelo.Estudiante;


@Stateless
public class EstudianteON {

	@Inject
	private EstudianteDAO edao;
	
	public void save(Estudiante estudiante) throws Exception {
		Estudiante aux= edao.read(estudiante.getCedula());
		if (aux != null) {
			throw new Exception("Estudiante ya registrado");
		} else {
			edao.insert(estudiante);
		}
	}
	
	public List<Estudiante> getListadoEstudiante(){
		return edao.getEstudiantes();
	}
	
	public void eliminar(String cedula) throws Exception{
		Estudiante aux=edao.read(cedula);
		if (aux == null) {
			throw new Exception("Persona no registrada");
		} else {
			edao.remove(cedula);
		}
	}
	
	public void actualizar(Estudiante estudiante) throws Exception {
		Estudiante aux=edao.read(estudiante.getCedula());
		if (aux == null) {
			throw new Exception("Estudiante no registrado");
		} else {
			edao.update(estudiante);
		}
	}
	
	public Estudiante getEst(String cedula) throws Exception{
		Estudiante aux=edao.read(cedula);
		if (aux == null) {
			throw new Exception("Es");
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
}

