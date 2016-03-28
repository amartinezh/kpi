package service.kpi.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.kpi.reporteHuman;
import domain.session.session;
import repository.kpi.HumanDao;
import service.kpi.HumanService;

@Service
public class HumanServiceImpl implements HumanService {
	
	@Autowired
	private HumanDao humanDao;
	
	public List<reporteHuman> listHuman(session ses) {
		return humanDao.listHuman(ses);
	}
	
	public List<reporteHuman> listHumanMonth(session ses) {
		return humanDao.listHumanMonth(ses);
	}
	
	public List<reporteHuman> listHumanQuarterly(session ses) {
		return humanDao.listHumanQuarterly(ses);
	}
}
