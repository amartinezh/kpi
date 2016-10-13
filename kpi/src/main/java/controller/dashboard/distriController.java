package controller.dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.adm.Plan;
import domain.kpi.reporteDistri;
import domain.session.session;
//import service.gestion.PlanService;
import service.kpi.DistriService;;

@Controller
@RequestMapping("/distri")
@SessionAttributes({ "user_inicio" })
public class distriController {

	@Autowired
	private DistriService distriService;
	
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
	
	
	
	@RequestMapping(value = "/distriYear", method = RequestMethod.GET)
	public String distriYear(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			int m= Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes());
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			List<reporteDistri> listado = distriService.listSales((session) model.asMap().get("user_inicio"));
			model.addAttribute("valor", listado);
			
			// Elimina los meses que no tienen información
			for (int j = 0; j < listado.size(); j++) {
				for (int i = listado.get(j).getLista().size()-1; i > 0; i--) {
					if (listado.get(j).getLista().get(i).getMveval().compareTo(java.math.BigDecimal.ZERO) == 0){
						if (i>=(m-1))
							listado.get(j).getLista().remove(i);
					}
				}
			}
			
			model.addAttribute("valorTam", listado.size());
			//System.out.println(listado.get(0).getLista().size());
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()
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
			return "distri/distriYear";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/distriMonth", method = RequestMethod.GET)
	public String distriMonth(Model model, @RequestParam String t, @RequestParam String op10) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setOp("M");
			// Lista
			model.addAttribute("valor", distriService.listSalesMonth((session) model.asMap().get("user_inicio")));
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"Currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio() +
					" >> Month: " + Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1]
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
			model.addAttribute("elmes", Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1]);
			return "distri/distriMonth";
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/distriQuarterly", method = RequestMethod.GET)
	public String salesQuarterly(Model model, @RequestParam String t) {
		if (model.containsAttribute("user_inicio") == true) {
			model.addAttribute("tit",t);
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			model.addAttribute("valor", distriService.listSalesQuarterly((session) model.asMap().get("user_inicio")));
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
			return "distri/distriQuarterly";
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
	public String chartjs(@RequestParam String i, @RequestParam String indicador, @RequestParam String p, @RequestParam String op, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			//model.addAttribute("valor", kpiService.listKip((session) model.asMap().get("user_inicio")));
			model.addAttribute("i",i);
			model.addAttribute("p",p);
			model.addAttribute("op",op);
			model.addAttribute("indicador",indicador);
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
	/// Método del controlador para cambiar la vista cuando seleccione diferente
	/////////////////////////////////////////////////////////////////////////////////// Año
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/mes", method = RequestMethod.POST)
	public String mes(@RequestParam String mes, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			((session) model.asMap().get("user_inicio")).setMes(mes);
			return "distri/distriMonth";
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
					((session) model.asMap().get("user_inicio")).setDash_tasa("mvevap");
				}
				else{
					((session) model.asMap().get("user_inicio")).setMoneda("mveval");
					((session) model.asMap().get("user_inicio")).setDash_tasa("mveval");
				}
				((session) model.asMap().get("user_inicio")).setDash_moneda("0");
				return "dashboard";
			} else if (m3r.equals("1")) {
				((session) model.asMap().get("user_inicio")).setDash_moneda("1");
				((session) model.asMap().get("user_inicio")).setMoneda("mvevac");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevac");
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
			System.out.println("Opción"+t4s4);
			if (t4s4.equals("p")) {
				((session) model.asMap().get("user_inicio")).setMoneda("mvevap");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mvevap");
				return "dashboard";
			} else if (t4s4.equals("m")) {
				((session) model.asMap().get("user_inicio")).setMoneda("mveval");
				((session) model.asMap().get("user_inicio")).setDash_tasa("mveval");
				
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
	/// Método del controlador para cambiar la vista cuando seleccione diferente moneda
	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/drilldown", method = RequestMethod.GET)
	public String drilldown(@RequestParam String m3r, @RequestParam String ind1c4, @RequestParam String ind1c4d3s, @RequestParam String ll4v3, @RequestParam String d3s, @RequestParam String op10n, @RequestParam String s1m, @RequestParam String op3r, Model model) {
		if (model.containsAttribute("user_inicio") == true) {
			String r=((session) model.asMap().get("user_inicio")).getDash_region();
			String n=((session) model.asMap().get("user_inicio")).getDash_nia();
			if (!r.equals("Todas")) r = regionService.getRegion(((session) model.asMap().get("user_inicio")).getDash_region()).get(0).getDescripcion();
			if (!n.equals("Todas")) n = companyService.listCompany__(((session) model.asMap().get("user_inicio")).getDash_nia()).get(0).getDescripcion();
			
			((session) model.asMap().get("user_inicio")).setCampo_llave(ll4v3);
			((session) model.asMap().get("user_inicio")).setCampo_descripcion(d3s);
			((session) model.asMap().get("user_inicio")).setIndicador_drill(ind1c4);
			((session) model.asMap().get("user_inicio")).setOp3r(op3r);
			
			model.addAttribute("tit",ind1c4d3s);
			model.addAttribute("m3r",m3r);
			model.addAttribute("s1m",s1m);
			((session) model.asMap().get("user_inicio")).setOp(s1m);
			
			model.addAttribute("r3g", ((session) model.asMap().get("user_inicio")).getDash_region());
			model.addAttribute("c1a", ((session) model.asMap().get("user_inicio")).getDash_nia());
			model.addAttribute("cur", ((session) model.asMap().get("user_inicio")).getDash_moneda());
			model.addAttribute("tas", ((session) model.asMap().get("user_inicio")).getDash_tasa());
			model.addAttribute("anio",((session) model.asMap().get("user_inicio")).getAnio());
			model.addAttribute("mes",((session) model.asMap().get("user_inicio")).getMes()+1);
			model.addAttribute("elmes", Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1]);
			
			String mesNavegacion="";
			if (op10n.equals("M"))
				mesNavegacion=" >> Month: " + Months.values()[Integer.parseInt(((session) model.asMap().get("user_inicio")).getMes())-1];
			
			model.addAttribute("navegacion",
					"Region: " + r + " >> " +
					"Company: " + n + " >> " +
					"currency: " + currencyService.getCurrency(((session) model.asMap().get("user_inicio")).getDash_moneda()).get(0).getDescripcion() + " >> " +
					(  ((session) model.asMap().get("user_inicio")).getDash_tasa()=="mvevap"?"Average":"Month Rate") +
					" >> Year: " + ((session) model.asMap().get("user_inicio")).getAnio()+
					mesNavegacion+
					" ( "+m3r+" )"
					);
			if (op10n.equals("M")){
				model.addAttribute("valor", distriService.listSalesDrillMonth((session) model.asMap().get("user_inicio")));
				return "drilldownMonth";
			}
			else{
				if (op10n.equals("Q")){
					model.addAttribute("valor", distriService.listSalesDrillQuarterly((session) model.asMap().get("user_inicio")));
					model.addAttribute("totales",((session) model.asMap().get("user_inicio")).getTotales());
					return "drilldownQuarterly";
				}
				else{
					if (op10n.equals("Y")){
						model.addAttribute("valor", distriService.listSalesDrill((session) model.asMap().get("user_inicio")));
						model.addAttribute("totales",((session) model.asMap().get("user_inicio")).getTotales());
						return "drilldown";
					}
					else{
						return "redirect:/index/ingreso";
					}
				}
			}
					
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

	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model, SessionStatus status) {
		status.setComplete();
		
		return "redirect:/index/ingreso";
	}
}
