package repository.adm;

import java.util.List;

import domain.adm.CfgHuman;

public interface CfgHumanDao {

	public List<CfgHuman> getCfg(String indicador);
	public List<CfgHuman> getListCfg();
	
}
