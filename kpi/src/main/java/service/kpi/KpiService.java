package service.kpi;

import java.util.List;

import domain.kpi.reporte;
import domain.session.session;

public interface KpiService {
	public List<reporte> listSales(session ses);
	public List<reporte> listSalesMonth(session ses);
	public List<reporte> listSalesQuarterly(session ses);
	public List<reporte> listSalesDrill(session ses);
	public List<reporte> listSalesDrillMonth(session ses);
	public List<reporte> listSalesDrillQuarterly(session ses);
}
