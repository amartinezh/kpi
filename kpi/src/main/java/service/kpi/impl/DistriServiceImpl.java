package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporteDistri;
import domain.session.session;
import repository.kpi.DistriDao;
import service.kpi.DistriService;

@Service
public class DistriServiceImpl implements DistriService {
	
	@Autowired
	private DistriDao distriDao;
	
	public List<reporteDistri> listSales(session ses) {
		return distriDao.listSales(ses);
	}
	
	public List<reporteDistri> listSalesMonth(session ses) {
		return distriDao.listSalesMonth(ses);
	}
	
	public List<reporteDistri> listSalesQuarterly(session ses) {
		return distriDao.listSalesQuarterly(ses);
	}
	
	public List<reporteDistri> listSalesDrill(session ses) {
		return distriDao.listSalesDrill(ses);
	}

	public List<reporteDistri> listSalesDrillMonth(session ses) {
		return distriDao.listSalesDrillMonth(ses);
	}
	
	public List<reporteDistri> listSalesDrillQuarterly(session ses) {
		return distriDao.listSalesDrillQuarterly(ses);
	}
}
