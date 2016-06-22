package service.adm;

import java.util.LinkedHashMap;
import java.util.List;

import domain.adm.Region;

public interface RegionService {
	public void agregarRegion(boolean existe, Region region);
	public void borrarRegion(Region region);
	public boolean validarRegion(Region region);
	public List<Region> listarRegion();
	
	public LinkedHashMap<String, String> cmbRegion();
	
	public List<Region> getRegion(String region);
	public Region getRegion_(String region);
	public List<Region> getListRegion();
}
