package repository.adm;

import java.util.List;

import domain.adm.CfgDistri;

public interface CfgDistriDao {

	public List<CfgDistri> getCfg(String indicador);
	public List<CfgDistri> getListCfg();
	
}
