package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.CfgFinance;
import repository.adm.CfgFinanceDao;
import service.adm.CfgFinanceService;

@Service
public class CfgFinanceServiceImpl implements CfgFinanceService{

	
	@Autowired
	private CfgFinanceDao cfgFinanceDao;
	
	
	public List<CfgFinance> getCfg(String indicador) {		
		return cfgFinanceDao.getCfg(indicador);
	}
	
	public List<CfgFinance> getListCfg() {
		return cfgFinanceDao.getListCfg();
	}

}
