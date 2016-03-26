package repository.kpi;

import java.util.List;

import domain.kpi.reporte;
//import domain.kpi.Reporte;
import domain.session.session;

public interface FinancesDao {

	public List<reporte> listFinance(session ses);
	public List<reporte> listFinanceMonth(session ses);
	public List<reporte> listFinanceQuarterly(session ses);
}
