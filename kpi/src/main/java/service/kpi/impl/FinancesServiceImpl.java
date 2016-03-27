package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporteFinance;
import domain.session.session;
import repository.kpi.FinancesDao;
import service.kpi.FinancesService;

@Service
public class FinancesServiceImpl implements FinancesService {
	
	@Autowired
	private FinancesDao FinanceDao;
	
	public List<reporteFinance> listFinance(session ses) {
		return FinanceDao.listFinance(ses);
	}
	
	public List<reporteFinance> listFinanceMonth(session ses) {
		return FinanceDao.listFinanceMonth(ses);
	}
	
	public List<reporteFinance> listFinanceQuarterly(session ses) {
		return FinanceDao.listFinanceQuarterly(ses);
	}
}
