package repository.adm;

import java.util.List;

import domain.adm.Currency;

public interface CurrencyDao {
	
	public List<Currency> listCurrency();
	public List<Currency> getCurrency(String id);
	public Currency getCurrency_(int id);
	
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
}
