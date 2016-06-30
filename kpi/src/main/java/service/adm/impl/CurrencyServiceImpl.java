package service.adm.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Company;
import domain.adm.Currency;
import domain.adm.Region;
import repository.adm.CurrencyDao;
import service.adm.CurrencyService;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	private CurrencyDao currencyDao;
	
	@Transactional
	public void agregarCurrency(boolean existe, Currency currency) {
		if (existe == true){
			currencyDao.actualizar(currency);
		}
		else {
			currencyDao.agregar(currency);
		}
	}

	@Transactional
	public void borrarCurrency(Currency currency) {
		Currency obj = (Currency) currencyDao.getElemento(currency, currency.getId());
		currencyDao.borrar(obj);
	}
	
	@Transactional
	public boolean validarCurrency(Currency currency) {
		Currency cont = (Currency) currencyDao.getElemento(currency, currency.getId());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public LinkedHashMap<String, String> cmbCurrency() {
		LinkedHashMap<String, String> listCurrency = new LinkedHashMap<String, String>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM Currency as a";
		List<Object[]> data = currencyDao.listar(sql);
		listCurrency.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listCurrency.put(d[0].toString(), d[1].toString());
			}
		}
		return listCurrency;
	}
	
	@Transactional
	public List<Currency> listarCurrency() {
		List<Currency> listCurrency = new LinkedList<Currency>();
		String sql = "Select a.id as id, a.descripcion as descripcion FROM Currency as a";
		List<Object[]> data = currencyDao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listCurrency.add(new Currency(Integer.parseInt( d[0].toString() ), d[1].toString()));
			}
		}
		return listCurrency;
	}
	
	public List<Currency> listCurrency() {
		return currencyDao.listCurrency();
	}
	
	public List<Currency> getCurrency(String id){
		return currencyDao.getCurrency(id);
	}
	
	public Currency getCurrency_(String id){
		return currencyDao.getCurrency_(Integer.parseInt(id));
	}
}
