package service.kpi;

import java.util.List;

import domain.kpi.reporteFinance;
import domain.session.session;

public interface FinancesService {
	public List<reporteFinance> listFinance(session ses);
	public List<reporteFinance> listFinanceMonth(session ses);
	public List<reporteFinance> listFinanceQuarterly(session ses);
}
