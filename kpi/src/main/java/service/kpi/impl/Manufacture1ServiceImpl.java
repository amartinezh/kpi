package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporteManufacture1;
import domain.session.session;
import repository.kpi.Manufacture1Dao;
import service.kpi.Manufactura1Service;

@Service
public class Manufacture1ServiceImpl implements Manufactura1Service {
	
	@Autowired
	private Manufacture1Dao manufactureDao;
	
	public List<reporteManufacture1> listSales(session ses, String table) {
		return manufactureDao.listSales(ses, table);
	}
	
	public List<reporteManufacture1> listSalesMonth(session ses, String table) {
		return manufactureDao.listSalesMonth(ses, table);
	}
	
	public List<reporteManufacture1> listSalesQuarterly(session ses, String table) {
		return manufactureDao.listSalesQuarterly(ses, table);
	}
	
	public List<reporteManufacture1> listSalesDrill(session ses, String table) {
		return manufactureDao.listSalesDrill(ses, table);
	}

	public List<reporteManufacture1> listSalesDrillMonth(session ses, String table) {
		return manufactureDao.listSalesDrillMonth(ses, table);
	}
	
	public List<reporteManufacture1> listSalesDrillQuarterly(session ses, String table) {
		return manufactureDao.listSalesDrillQuarterly(ses, table);
	}
}
