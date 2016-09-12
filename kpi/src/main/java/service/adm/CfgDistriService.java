package service.adm;

import java.util.List;

import domain.adm.CfgDistri;

public interface CfgDistriService {
	public List<CfgDistri> getCfg(String indicador);
	public List<CfgDistri> getListCfg();	
}