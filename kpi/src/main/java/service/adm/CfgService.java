package service.adm;

import java.util.List;

import domain.adm.Cfg;

public interface CfgService {

	public List<Cfg> getCfg(String indicador);
	public List<Cfg> getListCfg();
	
}
