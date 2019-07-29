package ec.edu.ups.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.dao.PeriodoDAO;
import ec.edu.ups.modelo.Periodo;

@Stateless
public class PeriodoON {
	@Inject
	private PeriodoDAO periodoDao;
	
	public void guardarPeriodo(Periodo periodo) throws Exception{
		periodoDao.createPeriodo(periodo);
	}
	public void eliminarPeriodo(int id) throws Exception {
		try {
			periodoDao.delete(id);
		} catch (Exception e) {
			throw new Exception("Error al eliminar "+e.getMessage());
		}
	}
	public Periodo getPeriod(int id) {
		Periodo per=periodoDao.read(id);
		return per;
	}
	public List<Periodo> getPeriodos(){
		List<Periodo> listaP=periodoDao.getPeriodos();
		return listaP;
	}
	
}
