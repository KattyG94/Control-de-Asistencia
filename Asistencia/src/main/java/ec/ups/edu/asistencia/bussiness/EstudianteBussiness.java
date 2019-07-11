package ec.ups.edu.asistencia.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.ups.edu.asistencia.dao.EstudianteDAO;
import ec.ups.edu.asistencia.model.Estudiante;

@Stateless
public class EstudianteBussiness {

	@Inject
	private EstudianteDAO edao;
	
	public void save(Estudiante estudiante) throws Exception {
		Estudiante aux= edao.read(estudiante.getId());
		if (aux != null) {
			throw new Exception("Estudiante ya registrado");
		} else {
			edao.insert(estudiante);
		}
	}
	
	public List<Estudiante> getListadoEstudiante(){
		return edao.getEstudiantes();
	}
	
	public void eliminar(int id) throws Exception{
		Estudiante aux=edao.read(id);
		if (aux == null) {
			throw new Exception("Estudiante no registrado");
		} else {
			edao.remove(id);
		}
	}
	
	public void actualizar(Estudiante estudiante) throws Exception {
		Estudiante aux=edao.read(estudiante.getId());
		if (aux == null) {
			throw new Exception("Estudiante no registrado");
		} else {
			edao.update(estudiante);
		}
	}
	
	public Estudiante getEst(int id) throws Exception{
		Estudiante aux=edao.read(id);
		if (aux == null) {
			throw new Exception("Estudiante no existe");
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
	
	public Estudiante buscar(int id) {
		return edao.bEstudiante(id);
	}
}
