package service.adm;

import java.util.List;

import domain.adm.CfgFinance;

public interface CfgFinanceService {

	public List<CfgFinance> getCfg(String indicador);
	public List<CfgFinance> getListCfg();
	
}
