package controller.dashboard;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import domain.adm.Plan;
import service.gestion.PlanService;

@Controller 
@RequestMapping("/plan")
@SessionAttributes({ "user_inicio" })
public class PlanController {

	@Autowired
	private PlanService planService;

	@RequestMapping(method = RequestMethod.GET)
	public String panel(Map<String, Object> model) {
		model.put("Plan", new Plan());
		model.put("listPlan", planService.listarPlan());
		return "admin/Plan";
	}

	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public @ResponseBody String agregar(
			@RequestParam int plan_id,
			@RequestParam String indicador, 
			@RequestParam String problema_encontrado,
			@RequestParam String impacto_discrepancia,
			@RequestParam String plan_accion,
			@RequestParam String tipo,
			@RequestParam String responsable,
			@RequestParam String resultado_esperado,
			@RequestParam String fecha_compromiso,
			@RequestParam String estado,
			
			Map<String, Object> model) {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		
			Plan obj = new Plan(plan_id, indicador, date, problema_encontrado, impacto_discrepancia, plan_accion, tipo, responsable, resultado_esperado, date, estado);
			System.out.println("aqui");	
			planService.agregarPlan(obj);
		return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('"
				+ obj.getPlan_id()
				+ "', '"
				+ obj.getIndicador()
				+ "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick='borrar("
				+ obj.getPlan_id()
				+ ", $(this))'><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ obj.getIndicador();
	}

	@RequestMapping(value = "cancelar", method = RequestMethod.POST)
	public @ResponseBody String cancelar(@RequestParam int Plan_id,
			@RequestParam String descripcion, Map<String, Object> model) {
		if (Plan_id > 0) {
			String cad = "";
			System.out.print(cad);
			return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
					+ " onclick=\"con('"
					+ Plan_id
					+ "', '"
					+ descripcion
					+ "', $(this)"
					+ ")\"><i class='fa fa-edit'></i></a>"
					+ " <a class='btn btn-danger btn-circle' onclick='borrar("
					+ Plan_id
					+ ", $(this))'><i class='fa fa-trash-o'></i></a>"
					+ "<span class='responsiveExpander'></span>:::"
					+ descripcion + "";
		} else {
			try {
				Integer.parseInt("a");
			} catch (Exception ex) {

			}
			return "";
		}
	}

	@RequestMapping(value = "borrar", method = RequestMethod.POST)
	public @ResponseBody String borrar(@RequestParam int Plan_id,
			Map<String, Object> model) {
		planService.borrarPlan(new Plan(Plan_id));
		return "";
	}

}
