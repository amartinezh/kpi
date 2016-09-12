package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.CfgDistri;
import repository.adm.CfgDistriDao;
import service.adm.CfgDistriService;

@Service
public class CfgDistriServiceImpl implements CfgDistriService{

	
	@Autowired
	private CfgDistriDao cfgDistriDao;
	
	
	public List<CfgDistri> getCfg(String indicador) {		
		return cfgDistriDao.getCfg(indicador);
	}
	
	public List<CfgDistri> getListCfg() {
		return cfgDistriDao.getListCfg();
	}

}
