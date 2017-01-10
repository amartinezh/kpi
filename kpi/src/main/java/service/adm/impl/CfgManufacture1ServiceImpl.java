package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.CfgManufacture1;
import repository.adm.CfgManufacture1Dao;
import service.adm.CfgManufacture1Service;

@Service
public class CfgManufacture1ServiceImpl implements CfgManufacture1Service{

	
	@Autowired
	private CfgManufacture1Dao cfgManufacture1Dao;
	
	
	public List<CfgManufacture1> getCfg(String indicador) {		
		return cfgManufacture1Dao.getCfg(indicador);
	}
	
	public List<CfgManufacture1> getListCfg() {
		return cfgManufacture1Dao.getListCfg();
	}

}
