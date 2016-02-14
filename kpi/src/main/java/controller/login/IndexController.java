package controller.login;

import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import domain.login.User;
import domain.session.session;
import repository.kpi.KpiDao;
import service.adm.CompanyService;
import service.adm.CurrencyService;
import service.adm.TypeUserService;
import service.kpi.KpiService;
import service.login.UserManager;

@Controller
@RequestMapping(value = "/index")
@SessionAttributes({ "user_inicio" })
public class IndexController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager userManager;

	@Autowired
	private TypeUserService typeUserService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private CurrencyService currencyService;
		

	/*
	 * @Autowired private PermisoManager permisoManager;
	 */
	@RequestMapping(value = "/ingreso", method = RequestMethod.GET)
	public String employee(Map<String, Object> model) {
		model.put("user", new User());
		return "key/index";
	}

	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("user") User user,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("user", new User());
			return "key/index";
		} else {
			User uss = userManager.val(user.getId(), user.getPass());
			if (uss != null) {
				model.addAttribute("user_inicio", new session("mveval", "COL", "01", "0", "mvevap"));
				return "redirect:/indicadores/inicio";
			} else {
				model.addAttribute("user", new User());
				model.addAttribute(
						"msg",
						"<script type=\"text/javascript\">$( window ).load(function() { adv(); }); </script>");
				return "key/index";
			}
		}
	}
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model, SessionStatus status) {
		status.setComplete();
		model.addAttribute("user_inicio", new session() );
		return "redirect:/index/ingreso";
	}

	public void setuserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}
