package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.Cfg;
import repository.adm.CfgDao;
import service.adm.CfgService;

@Service
public class CfgServiceImpl implements CfgService{

	
	@Autowired
	private CfgDao cfgDao;
	
	
	public List<Cfg> getCfg(String indicador) {		
		return cfgDao.getCfg(indicador);
	}
	
	public List<Cfg> getListCfg() {
		return cfgDao.getListCfg();
	}

}
