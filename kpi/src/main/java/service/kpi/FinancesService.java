package service.kpi;

import java.util.List;

import domain.kpi.reporte;
import domain.session.session;

public interface FinancesService {
	public List<reporte> listFinance(session ses);
}
