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
	
	public List<reporte> listKip(session ses) {
		return kpiDao.listKip(ses);
	}
	
	public List<reporte> listKipDrill(session ses) {
		return kpiDao.listKipDrill(ses);
	}

}
