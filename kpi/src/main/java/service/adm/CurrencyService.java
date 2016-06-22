package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Currency;
import domain.adm.Region;

public interface CurrencyService {

	public List<Currency> listCurrency();
	public List<Currency> getCurrency(String id);
	
	public void agregarRegion(boolean existe, Region region);
	public void borrarRegion(Region region);
	public boolean validarRegion(Region region);
	public LinkedHashMap<String, String> cmbRegion();
}
