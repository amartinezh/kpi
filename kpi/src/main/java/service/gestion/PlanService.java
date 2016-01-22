package service.gestion;

import java.util.List;
import java.util.Map;

import domain.adm.Plan;

public interface PlanService {
	
	public void agregarPlan(Plan plan);
	public void borrarPlan(Plan plan);
	public List<Plan> listarPlan();
	public Map<Integer, String> cmbPlan();
}