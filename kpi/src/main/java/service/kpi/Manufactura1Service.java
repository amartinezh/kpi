package service.kpi;

import java.util.List;

import domain.kpi.reporteManufacture1;
import domain.session.session;

public interface Manufactura1Service {
	public List<reporteManufacture1> listSales(session ses, String table);
	public List<reporteManufacture1> listSalesMonth(session ses, String table);
	public List<reporteManufacture1> listSalesQuarterly(session ses, String table);
	public List<reporteManufacture1> listSalesDrill(session ses, String table);
	public List<reporteManufacture1> listSalesDrillMonth(session ses, String table);
	public List<reporteManufacture1> listSalesDrillQuarterly(session ses, String table);
}
