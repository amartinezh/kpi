package repository.kpi;

import java.util.List;
import java.util.Map;

import domain.kpi.Kpi;
import domain.kpi.reporte;
//import domain.kpi.Reporte;
import domain.session.session;

public interface FinancesDao {

	public List<reporte> listFinances(session ses);
}
