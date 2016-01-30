package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.Dao;
import dao.DaoSolde;
import dao.DaoTransaction;

@Controller
public class SprController {

	Dao dao;
	DaoTransaction tdao;
	DaoSolde sdao;

	@Autowired
	public void setSdao(DaoSolde sdao) {
		this.sdao = sdao;
	}

	@Autowired
	public void setTdao(DaoTransaction tdao) {
		this.tdao = tdao;
	}

	@Autowired
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@RequestMapping("/")
	public ModelAndView homepage() {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("index");
		return modelview;

	}

	@RequestMapping("/login")
	public ModelAndView loginpage() {
		ModelAndView modelview = new ModelAndView();
		modelview.setViewName("login");
		return modelview;
	}

	@RequestMapping(value = "adminindex", method = RequestMethod.GET)
	public ModelAndView adminpage() {
		ModelAndView modelview = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		int id = dao.findByLogin(name);

		modelview.addObject("l", dao.getClient(id));
		modelview.addObject("transaction", tdao.findAll());
		modelview.addObject("lp", dao);
		modelview.setViewName("admin/index");
		return modelview;
	}

	@RequestMapping(value = "userindex", method = RequestMethod.GET)
	public ModelAndView userpage() {
		ModelAndView modelview = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();

		System.out.println("************" + name + "*****");
		int id = dao.findByLogin(name);

		modelview.addObject("l", dao.getClient(id));
		modelview.addObject("lp", tdao.findAllByClient(id));
		modelview.addObject("solde", sdao.getSolde(id));
		modelview.setViewName("user/index");
		return modelview;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
