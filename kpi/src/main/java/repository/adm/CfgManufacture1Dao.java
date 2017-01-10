package repository.adm;

import java.util.List;

import domain.adm.CfgManufacture1;

public interface CfgManufacture1Dao {

	public List<CfgManufacture1> getCfg(String indicador);
	public List<CfgManufacture1> getListCfg();
	
}
