package controller.dashboard;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.adm.Company;
import domain.adm.Plan;
import domain.adm.Region;
import domain.session.session;
//import service.gestion.PlanService;
import service.kpi.KpiService;

@Controller
@RequestMapping("/indicadores")
@SessionAttributes({ "user_inicio" })
public class salesController {

	@Autowired
	private KpiService kpiService;
	
	@Autowired
	private service.adm.RegionService regionService;
	
	@Autowired
	private service.adm.CompanyService companyService;
	
	@Autowired
	private service.adm.CurrencyService currencyService;

	//@Autowired
	//private PlanService planService;
	
	private enum Months {
		January, February, March, April, May, June, July, August, September, October, November, December;
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String menu(Model model, @RequestParam String t, @RequestParam String r3g, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			model.addAttribute("r3g",r3g);
			model.addAttribute("op10",op10);
			switch (Integer.parseInt(op10)) {
            	case 1: 
            		model.addAttribute("view","salesMonth");
            		break;
            	case 2: 
            		model.addAttribute("view","salesYear");
            		break;
            	case 3: 
            		model.addAttribute("view", "salesQuarterly");
            		break;
            	default:
            		break;
			}
			return "menu";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/salesYear", method = RequestMethod.GET)
	public String salesYear(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", kpiService.listSales((session) model.asMap().get("user_inicio")));
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			//if (((session) model.asMap().get("user_inicio")).getDash_region().equals("Todas")){
				model.addAttribute("currencyList", currencyService.listCurrency());
			//}
			//else{
			//	model.addAttribute("currencyList", "0");
			//}
			
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			return "salesYear";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/salesMonth", method = RequestMethod.GET)
	public String salesMonth(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setOp("M");
			// Lista
			model.addAttribute("valor", kpiService.listSalesMonth((session) model.asMap().get("user_inicio")));
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio() +
					" >> Month: " + Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())]
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			model.addAttribute("currencyList", currencyService.listCurrency());
			
			model.addAttribute("op10",op10);
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			model.addAttribute("mes",((session) model.asMap().get("user_inicio")).getMes());
			model.addAttribute("elmes", Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())]);
			return "salesMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/salesQuarterly", method = RequestMethod.GET)
	public String salesQuarterly(Model model, @RequestParam String t) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", kpiService.listSalesQuarterly((session) model.asMap().get("user_inicio")));
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
					);
			
			model.addAttribute("regionList", regionService.getListRegion());
			model.addAttribute("currencyList", currencyService.listCurrency());
			
			model.addAttribute("companyList", companyService.listCompany(((session) model.asMap().get("user_inicio")).getDash_region()));
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			return "salesQuarterly";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/get_region", method = RequestMethod.POST)
	@ResponseBody
	public String get_region(@RequestParam String r3g) {
			return companyService.listCompany_(r3g);
	}

	@RequestMapping(value = "/chartjs", method = RequestMethod.GET)
	public String chartjs(Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			//model.addAttribute("valor", kpiService.listKip((session) model.asMap().get("user_inicio")));
			return "chartjs";
		} else {
			return "redirect:/index/ingreso";
		}
	}

	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente moneda
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/cia", method = RequestMethod.POST)
	public String cia(@RequestParam String r3g, @RequestParam String c1a, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setDash_region(r3g);
			((session) model.asMap().get("user_inicio")).setDash_nia(c1a);
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente moneda
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/moneda", method = RequestMethod.POST)
	public String agrega(@RequestParam String m3r, @RequestParam String t4s4, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			if (m3r.equals("0")) {
				if (t4s4.equals("p")){
					((session) model.asMap().get("user_inicio")).setMoneda("mvevap");
				}
				else{
					((session) model.asMap().get("user_inicio")).setMoneda("mveval");
				}
				((session) model.asMap().get("user_inicio")).setDash_moneda("0");
				return "dashboard";
			} else if (m3r.equals("1")) {
				((session) model.asMap().get("user_inicio")).setDash_moneda("1");
				((session) model.asMap().get("user_inicio")).setMoneda("mvevac");
				return "dashboard";
			} else {
				return "redirect:/index/ingreso";
			}
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente tasa
	/////////////////////////////////////////////////////////////////////////////////// 
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/tasa", method = RequestMethod.POST)
	public String tasa(@RequestParam String t4s4, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			if (t4s4.equals("p")) {
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevap");
				return "dashboard";
			} else if (t4s4.equals("m")) {
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevpe");
				return "dashboard";
			} else {
				return "redirect:/index/ingreso";
			}
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente Año
	/////////////////////////////////////////////////////////////////////////////////// 
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/anio", method = RequestMethod.POST)
	public String anio(@RequestParam String anio, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setAnio(anio);
			return "dashboard";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente Año
	/////////////////////////////////////////////////////////////////////////////////// 
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/mes", method = RequestMethod.POST)
	public String mes(@RequestParam String mes, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setMes(mes);
			return "salesMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}

	///////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para cambiar la vista cuando seleccione diferente moneda
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/drilldown", method = RequestMethod.GET)
	public String drilldown(@RequestParam String m3r, @RequestParam String ind1c4, @RequestParam String ind1c4d3s, @RequestParam String ll4v3, @RequestParam String d3s, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setCampo_llave(ll4v3);
			((session) model.asMap().get("user_inicio")).setCampo_descripcion(d3s);
			((session) model.asMap().get("user_inicio")).setIndicador_drill(ind1c4);
			
			model.addAttribute("valor", kpiService.listSalesDrill((session) model.asMap().get("user_inicio")));
			model.addAttribute("tit",ind1c4d3s);
			model.addAttribute("m3r",m3r);
			
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
					);
			return "drilldown";
					
		} else {
			return "redirect:/index/ingreso";
		}
	}

	/*
	18.531.526
	Edgar Augusto Pulgarin
	182.000
	
	
	Madera 76000+9000=85000
	*/
	///////////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para llamar la vista de planes de acción ///

	@RequestMapping(value = "/plan", method = RequestMethod.POST)
	public String carga(@RequestParam String ind1c4, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setIndicador(ind1c4);
			model.asMap().put("plan", new Plan());
			((session) model.asMap().get("user_inicio")).setInterfaz("plan");
			return "gestion/plan";
		} else {
			return "redirect:/index/ingreso";
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////
	/// Método del controlador para llamar la vista de planes de acción ///

	/* @RequestMapping(value = "/plan", method = RequestMethod.GET)
	public String carga2(@RequestParam String ind1c4, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setIndicador(ind1c4);
			model.asMap().put("plan", new Plan());
			model.asMap().put("listPlan", planService.listarPlan());
			((session) model.asMap().get("user_inicio")).setInterfaz("plan");

			return "gestion/plan";
		} else {
			return "redirect:/index/ingreso";
		}
	} */

	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model, SessionStatus status) {
		status.setComplete();
		
		return "redirect:/index/ingreso";
	}

	/* @RequestMapping(value = "/agregar", method = RequestMethod.POST)
	public @ResponseBody String agregar(@RequestParam int plan_id, @RequestParam String indicador,
			@RequestParam String problema_encontrado, @RequestParam String impacto_discrepancia,
			@RequestParam String plan_accion, @RequestParam String tipo, @RequestParam String responsable,
			@RequestParam String resultado_esperado, @RequestParam String fecha_compromiso, @RequestParam String estado,

			Map<String, Object> model) {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

		Plan obj = new Plan(plan_id, indicador, date, problema_encontrado, impacto_discrepancia, plan_accion, tipo,
				responsable, resultado_esperado, date, estado);
		System.out.println("aqui");
		planService.agregarPlan(obj);
		return "<span class='responsiveExpander'></span><a class='btn btn-success btn-circle btn-sx'"
				+ " onclick=\"con('" + obj.getPlan_id() + "', '" + obj.getIndicador() + "', $(this)"
				+ ")\"><i class='fa fa-edit'></i></a> <a class='btn btn-danger btn-circle' onclick='borrar("
				+ obj.getPlan_id()
				+ ", $(this))'><i class='fa fa-trash-o'></i></a><span class='responsiveExpander'></span>:::"
				+ obj.getIndicador();
	}
     */
}
