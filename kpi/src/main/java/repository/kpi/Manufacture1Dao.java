package repository.kpi;

import java.util.List;

import domain.kpi.reporteManufacture1;
//import domain.kpi.Reporte;
import domain.session.session;

public interface Manufacture1Dao {

	public List<reporteManufacture1> listSales(session ses, String table);
	public List<reporteManufacture1> listSalesMonth(session ses, String table);
	public List<reporteManufacture1> listSalesQuarterly(session ses, String table);
	public List<reporteManufacture1> listSalesDrill(session ses, String table);
	public List<reporteManufacture1> listSalesDrillMonth(session ses, String table);
	public List<reporteManufacture1> listSalesDrillQuarterly(session ses, String table);

}