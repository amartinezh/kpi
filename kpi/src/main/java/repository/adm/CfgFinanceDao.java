package repository.adm;

import java.util.List;

import domain.adm.CfgFinance;;

public interface CfgFinanceDao {

	public List<CfgFinance> getCfg(String indicador);
	public List<CfgFinance> getListCfg();
	
}
