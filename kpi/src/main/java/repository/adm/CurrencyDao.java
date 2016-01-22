package repository.adm;

import java.util.List;

import domain.adm.Currency;

public interface CurrencyDao {
	
	public List<Currency> listCurrency();
	public List<Currency> getCurrency(String id);
}
