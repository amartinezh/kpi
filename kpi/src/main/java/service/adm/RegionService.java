package service.adm;

import java.util.List;
import domain.adm.Region;

public interface RegionService {
	public List<Region> getRegion(String region);
	public List<Region> getListRegion();
}
