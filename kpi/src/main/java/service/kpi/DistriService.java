package service.kpi;

import java.util.List;

import domain.kpi.reporteDistri;
import domain.session.session;

public interface DistriService {
	public List<reporteDistri> listSales(session ses);
	public List<reporteDistri> listSalesMonth(session ses);
	public List<reporteDistri> listSalesQuarterly(session ses);
	public List<reporteDistri> listSalesDrill(session ses);
	public List<reporteDistri> listSalesDrillMonth(session ses);
	public List<reporteDistri> listSalesDrillQuarterly(session ses);
}
