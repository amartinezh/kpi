package service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.adm.Region;
import repository.adm.RegionDao;
import service.adm.RegionService;

@Service
public class RegionServiceImpl_2{
	
	@Autowired
	private RegionDao cfgDao;
	
	public List<Region> getRegion(String region) {		
		return cfgDao.getRegion(region);
	}
	
	public List<Region> getListRegion() {
		return cfgDao.getListRegion();
	}
	
	public Region getRegion_(String region) {
		return  cfgDao.getRegion_(region);
	}
}
