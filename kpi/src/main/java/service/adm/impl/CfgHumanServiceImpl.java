package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.CfgHuman;
import repository.adm.CfgHumanDao;
import service.adm.CfgHumanService;

@Service
public class CfgHumanServiceImpl implements CfgHumanService{

	
	@Autowired
	private CfgHumanDao cfgHumanDao;
	
	
	public List<CfgHuman> getCfg(String indicador) {		
		return cfgHumanDao.getCfg(indicador);
	}
	
	public List<CfgHuman> getListCfg() {
		return cfgHumanDao.getListCfg();
	}

}
