package service.adm.impl;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Region;
import service.adm.RegionService;
 
@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private repository.gestion.RepositorioDao cfgDao;
	
	@Autowired
	private repository.adm.RegionDao regionDAO;
	

	@Transactional
	public void agregarRegion(boolean existe, Region region) {
		if (existe == true){
			cfgDao.actualizar(region);
		}
		else {
			cfgDao.agregar(region);
		}
	}

	@Transactional
	public void borrarRegion(Region region) {
		Region obj = (Region) cfgDao.getElemento(region,
				region.getRegion_id());
		cfgDao.borrar(obj);
	}
	
	@Transactional
	public boolean validarRegion(Region region) {
		Region cont = (Region) regionDAO.getElemento(region, region.getRegion_id());
		if (cont == null)
			return false;
		return true;
	}
	
	@Transactional
	public List<Region> listarRegion() {
		List<Region> listRegion = new LinkedList<Region>();
		String sql = "Select a.region_id as region_id, a.descripcion as descripcion FROM Region as a";
		List<Object[]> data = cfgDao.listar(sql);
		if (data != null) {
			for (Object[] d : data) {
				listRegion.add(new Region(d[0].toString(), d[1].toString()));
			}
		}
		return listRegion;
	}

	@Transactional
	public LinkedHashMap<String, String> cmbRegion() {
		LinkedHashMap<String, String> listActividad = new LinkedHashMap<String, String>();
		String sql = "Select a.region_id as region_id, a.descripcion as descripcion FROM Region as a";
		List<Object[]> data = cfgDao.listar(sql);
		listActividad.put("0", "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				listActividad.put(d[0].toString(), d[1].toString());
			}
		}
		return listActividad;
	}
	
	public List<Region> getRegion(String region) {		
		return regionDAO.getRegion(region);
	}
	
	public List<Region> getListRegion() {
		return regionDAO.getListRegion();
	}
	
	public Region getRegion_(String region) {
		return  regionDAO.getRegion_(region);
	}

}
