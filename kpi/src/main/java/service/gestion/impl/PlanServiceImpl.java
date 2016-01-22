package service.gestion.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.adm.Plan;
import repository.gestion.RepositorioDao;
import service.gestion.PlanService;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private RepositorioDao PlanDao;

	@Transactional
	public void agregarPlan(Plan Plan) {
		if (Plan.getPlan_id() == 0)
			Plan = (Plan) PlanDao.agregar_get(Plan);
		else {
			Plan obj = (Plan) PlanDao.getElemento(Plan, Plan.getPlan_id());
			obj.setIndicador(Plan.getIndicador());
			obj.setProblema_encontrado(Plan.getProblema_encontrado());
			obj.setImpacto_discrepancia(Plan.getImpacto_discrepancia());
			obj.setPlan_accion(Plan.getPlan_accion());
			obj.setTipo(Plan.getTipo());
			obj.setResponsable(Plan.getResponsable());
			obj.setResultado_esperado(Plan.getResultado_esperado());
			obj.setFecha_compromiso(Plan.getFecha_compromiso());
			obj.setEstado(Plan.getEstado());
			PlanDao.actualizar(Plan);
		}
	}

	@Transactional
	public void borrarPlan(Plan Plan) {
		Plan are = (Plan) PlanDao.getElemento(Plan, Plan.getPlan_id());
		PlanDao.borrar(are);
	}

	@Transactional
	public List<Plan> listarPlan() {
		List<Plan> listPlan = new LinkedList<Plan>();
		String sql = "Select a.plan_id as plan_id, "
				+ " a.indicador as indicador, a.fecha as fecha, a.problema_encontrado as problema_encontrado, "
				+ " a.impacto_discrepancia as impacto_discrepancia, a.plan_accion as plan_accion, "
				+ " a.tipo as tipo, a.responsable as responsable, a.resultado_esperado as resultado_esperado, "
				+ " a.fecha_compromiso as fecha_compromiso, a.estado as estado  FROM Plan as a";
		List<Object[]> data = PlanDao.listar(sql);
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		if (data != null) {
			for (Object[] d : data) {
				try {
					listPlan.add(new Plan(Integer.parseInt(d[0].toString()), d[1].toString(), formatter.parse(d[2].toString()), d[3].toString(), d[4].toString(), d[5].toString(), d[6].toString(), d[7].toString(), d[8].toString(), formatter.parse(d[9].toString()), d[10].toString()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return listPlan;
	}
	
	@Transactional
	public Map<Integer, String> cmbPlan() {
		Map<Integer, String> Plans = new HashMap<Integer, String>();
		String sql = "Select a.Plan_id as Plan_id, a.indicador as indicador FROM Plan as a";
		List<Object[]> data = PlanDao.listar(sql);
		Plans.put(0, "Seleccione");
		if (data != null) {
			for (Object[] d : data) {
				Plans.put(Integer.parseInt(d[0].toString()), d[1].toString());
			}
		}
		return Plans;
	}

}
