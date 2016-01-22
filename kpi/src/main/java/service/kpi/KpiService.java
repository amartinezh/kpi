package service.kpi;

import java.util.List;

import domain.kpi.reporte;
import domain.session.session;

public interface KpiService {
	
	public List<reporte> listKip(session ses);
	public List<reporte> listKipDrill(session ses);

}
