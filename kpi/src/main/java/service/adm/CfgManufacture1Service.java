package service.adm;

import java.util.List;

import domain.adm.CfgManufacture1;

public interface CfgManufacture1Service {
	public List<CfgManufacture1> getCfg(String indicador);
	public List<CfgManufacture1> getListCfg();	
}