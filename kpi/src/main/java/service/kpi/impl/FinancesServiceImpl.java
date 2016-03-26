package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporte;
import domain.session.session;
import repository.kpi.FinancesDao;
import service.kpi.FinancesService;

@Service
public class FinancesServiceImpl implements FinancesService {
	
	@Autowired
	private FinancesDao FinanceDao;
	
	public List<reporte> listFinances(session ses) {
		return FinanceDao.listFinances(ses);
	}
}
