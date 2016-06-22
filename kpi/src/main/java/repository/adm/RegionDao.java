package repository.adm;

import java.util.List;

import domain.adm.Region;

public interface RegionDao {
	public List<Region> getRegion(String region);
	public List<Region> getListRegion();
	public Region getRegion_(String region);
	
	public void agregar(Object obj);
	public Object agregar_get(Object obj);
	public void actualizar(Object obj);
	public void borrar(Object obj);
	public List<Object[]> listar(String sql);
	public Object getElemento(Object obj, int id);
	public Object getElemento(Object obj, String id);
}
