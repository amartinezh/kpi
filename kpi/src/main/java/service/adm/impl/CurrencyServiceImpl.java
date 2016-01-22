package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.Currency;
import repository.adm.CurrencyDao;
import service.adm.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDao currencyDao;
	
	public List<Currency> listCurrency() {
		return currencyDao.listCurrency();
	}
	
	public List<Currency> getCurrency(String id){
		return currencyDao.getCurrency(id);
	}
}
