package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Currency;
import domain.adm.Region;

public interface CurrencyService {

	public List<Currency> listCurrency();
	public List<Currency> getCurrency(String id);
	public Currency getCurrency_(String id);
	
	public void agregarCurrency(boolean existe, Currency currency);
	public void borrarCurrency(Currency currency);
	public boolean validarCurrency(Currency currency);
	public List<Currency> listarCurrency();
	public LinkedHashMap<String, String> cmbCurrency();
}