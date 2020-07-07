package it.circuitoinformatico.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import it.circuitoinformatico.model.Utente;
import it.circuitoinformatico.service.UtenteService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	UtenteService utenteService;
	
	@RequestMapping(value="/creaUtente", method=RequestMethod.GET)
	public ModelAndView creaUtente() {
		ModelAndView model = new ModelAndView("login_form");
		
		Utente utente = new Utente();
		model.addObject("loginForm",utente);
		model.setViewName("login_form");
		return model;
		
	}

	@RequestMapping(value="/registrati", method=RequestMethod.POST)
	public ModelAndView utenti(@ModelAttribute("loginForm")Utente utente,HttpSession session) {

		if(utenteService.getUtenteByUsername(utente.getUsername()).size() == 0) {
			
			utenteService.saveOrUpdate(utente);
			
			 session.setAttribute("id", utente.getId());
			 session.setAttribute("username", utente.getUsername());
		     session.setAttribute("password", utente.getPassword());
			
			return new ModelAndView("redirect:/quiz/list");

		}

		return new ModelAndView("redirect:/user/creaUtente");

	}

	@RequestMapping(value="/accedi", method=RequestMethod.POST)
	public ModelAndView checkUtente(@ModelAttribute("loginForm")Utente utente,HttpSession session)  {

		if(utenteService.getUtenteByUsernameAndPassword(utente.getUsername(),utente.getPassword()).size() == 1) {
			
			session.setAttribute("id", utente.getId());
	        session.setAttribute("username", utente.getUsername());
	        session.setAttribute("password", utente.getPassword());

			return new ModelAndView("redirect:/quiz/list");

		}
		
		return new ModelAndView("redirect:/user/creaUtente");
	}

	@RequestMapping(value="/updateUtente/{id}", method=RequestMethod.GET)
	public ModelAndView editQuiz(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Utente utente  = utenteService.getUtenteById(id);
		model.addObject("loginForm",utente);
		model.setViewName("login_form");

		return model;
	}

	@RequestMapping(value="/saveUtente", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("loginForm") Utente utente) {
		utenteService.saveOrUpdate(utente);

		return new ModelAndView("redirect:/quiz/list/" );
	}

	@RequestMapping(value="/deleteUtente/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		utenteService.deleteUtente(id);

		return new ModelAndView("redirect:/quiz/list");
	}
}
