package service.adm;

import java.util.List;

import domain.adm.CfgHuman;

public interface CfgHumanService {

	public List<CfgHuman> getCfg(String indicador);
	public List<CfgHuman> getListCfg();
	
}
