package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporte;
import domain.session.session;
import repository.kpi.KpiDao;
import service.kpi.KpiService;

@Service
public class KpiServiceImpl implements KpiService {
	
	@Autowired
	private KpiDao kpiDao;
	
	public List<reporte> listSales(session ses) {
		return kpiDao.listSales(ses);
	}
	
	public List<reporte> listSalesMonth(session ses) {
		return kpiDao.listSalesMonth(ses);
	}
	
	public List<reporte> listSalesQuarterly(session ses) {
		return kpiDao.listSalesQuarterly(ses);
	}
	
	public List<reporte> listSalesDrill(session ses) {
		return kpiDao.listSalesDrill(ses);
	}

	public List<reporte> listSalesDrillMonth(session ses) {
		return kpiDao.listSalesDrillMonth(ses);
	}
	
	public List<reporte> listSalesDrillQuarterly(session ses) {
		return kpiDao.listSalesDrillQuarterly(ses);
	}
}
