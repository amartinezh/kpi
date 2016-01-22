package repository.adm;

import java.util.List;

import domain.adm.Cfg;

public interface CfgDao {

	public List<Cfg> getCfg(String indicador);
	public List<Cfg> getListCfg();
	
}
