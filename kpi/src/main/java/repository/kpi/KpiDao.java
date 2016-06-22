package repository.kpi;

import java.util.List;
import java.util.Map;

import domain.adm.Region;
import domain.kpi.Kpi;
import domain.kpi.reporte;
//import domain.kpi.Reporte;
import domain.session.session;

public interface KpiDao {

	public List<reporte> listSales(session ses);
	public List<reporte> listSalesMonth(session ses);
	public List<reporte> listSalesQuarterly(session ses);
	public List<reporte> listSalesDrill(session ses);
	public List<reporte> listSalesDrillMonth(session ses);
	public List<reporte> listSalesDrillQuarterly(session ses);

}