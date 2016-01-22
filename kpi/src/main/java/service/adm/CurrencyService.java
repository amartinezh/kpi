package service.adm;

import java.util.List;

import domain.adm.Currency;

public interface CurrencyService {

	public List<Currency> listCurrency();
	public List<Currency> getCurrency(String id);
}
