package repository.adm;

import java.util.List;

import domain.adm.Region;

public interface RegionDao {
	public List<Region> getRegion(String region);
	public List<Region> getListRegion();
}
