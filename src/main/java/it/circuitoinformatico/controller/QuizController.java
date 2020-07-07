package it.circuitoinformatico.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import it.circuitoinformatico.model.*;
import it.circuitoinformatico.service.*;

@Controller
@RequestMapping(value="/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@Autowired
	DomandaService domandaService;
	

	@Autowired
	RispostaService rispostaService;
	
	@Autowired
	UtenteService utenteService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list(HttpSession session) {
		ModelAndView model = new ModelAndView("quiz_list");
		List<Quiz> quizList = quizService.getAllQuizzes();
		
		Utente utente = utenteService.getUtenteByUsername(session.getAttribute("username").toString()).get(0);
		
		model.addObject("sessionUser",utente);
		
		model.addObject("quizList", quizList);

		return model;
	}
	
	@RequestMapping(value="/addQuiz/", method=RequestMethod.GET)
	public ModelAndView addQuiz() {
		ModelAndView model = new ModelAndView();

		Quiz quiz = new Quiz();
		model.addObject("quizForm", quiz);
		model.setViewName("quiz_form");

		return model;
	}
	
	@RequestMapping(value="/updateQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView editQuiz(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Quiz quiz  = quizService.getQuizById(id);
		model.addObject("quizForm", quiz);
		model.setViewName("quiz_form");
		
		return model;
	}

	@RequestMapping(value="/saveQuiz", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("quizForm") Quiz quiz) {
		quizService.saveOrUpdate(quiz);

		return new ModelAndView("redirect:/quiz/list/" );
	}
	
	@RequestMapping(value="/detQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView showQuiz(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Quiz quiz = quizService.getQuizById(id);
		model.addObject("quizDetails", quiz);
		model.setViewName("quiz_details");

		return model;
	}
	
	@RequestMapping(value="/dettQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView showQuizDet(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		
		Quiz quiz = quizService.getQuizById(id);
		List<Domanda> domande = domandaService.getAllDomandeByQuizId(quiz.getId());
		
		model.addObject("quizList",quiz);
		model.addObject("questionList", domande);
		model.setViewName("quiz_det");
		
		return model;
	}

	@RequestMapping(value="/deleteQuiz/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
		quizService.deleteQuiz(id);

		return new ModelAndView("redirect:/quiz/list");
	}
	
	@RequestMapping(value="/deleteDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView deleteDomanda(@PathVariable("id") long id) {
		domandaService.deleteQuestion(id);
		return new ModelAndView("redirect:/quiz/list");
	}
	
	@RequestMapping(value="/addDomanda/{quizid}", method=RequestMethod.GET)
	public ModelAndView addDomanda(@PathVariable("quizid") long quizid) {
		ModelAndView model = new ModelAndView();

		Domanda domanda = new Domanda();
		Quiz quiz = quizService.getQuizById(quizid);
		domanda.setQuiz(quiz);
		model.addObject("domandaForm", domanda);
		model.setViewName("domanda_form");

		return model;
	}
	
	@RequestMapping(value="/saveDomanda", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("domandaForm") Domanda domanda) {
		
		Quiz quiz = quizService.getQuizById(domanda.getQuiz().getId());
		domanda.setQuiz(quiz);
        domandaService.saveOrUpdate(domanda);

		return new ModelAndView("redirect:/quiz/dettQuiz/" + domanda.getQuiz().getId());
    }
	
	@RequestMapping(value="/editDomanda/{id}", method=RequestMethod.GET)
	public ModelAndView editDomanda(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Domanda domanda = domandaService.getQuestionById(id);
		model.addObject("domandaForm", domanda);
		model.setViewName("domanda_form");

		return model;
	}
	
	@RequestMapping(value="/showRisposte/{id}", method=RequestMethod.GET)
	public ModelAndView showRisposte(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		
		Domanda domande = domandaService.getQuestionById(id);
		List<Risposta> risposte = rispostaService.getAllRispostebyDomandaId(domande.getId());
		
		model.addObject("answerList", risposte);
		model.addObject("domanda", domande);
		model.setViewName("risposte");
		
		return model;
	}
	
	@RequestMapping(value="/deleteRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView deleteRisposta(@PathVariable("id") long id) {
		
        Risposta risposta = rispostaService.getAnswerById(id);
		rispostaService.deleteAnswer(id);
		return new ModelAndView("redirect:/quiz/showRisposte/" + risposta.getDomanda().getId());
	}
	
	@RequestMapping(value="/addRisposta/{rispostaid}", method=RequestMethod.GET)
	public ModelAndView addRisposta(@PathVariable("rispostaid") long rispostaid) {
		ModelAndView model = new ModelAndView();

		Risposta risposta = new Risposta();
		Domanda domanda = domandaService.getQuestionById(rispostaid);
		risposta.setDomanda(domanda);
		model.addObject("risposteForm", risposta);
		model.setViewName("risposte_form");

		return model;
	}
	
	@RequestMapping(value="/saveRisposta", method=RequestMethod.POST)
    public ModelAndView saveRisposta(@ModelAttribute("risposteForm") Risposta risposta) {
		
		Domanda domanda = domandaService.getQuestionById(risposta.getDomanda().getId());
		risposta.setDomanda(domanda);
        rispostaService.saveOrUpdate(risposta);

        return new ModelAndView("redirect:/quiz/showRisposte/" + risposta.getDomanda().getId());
    }
	
	@RequestMapping(value="/editRisposta/{id}", method=RequestMethod.GET)
	public ModelAndView editRisposta(@PathVariable long id) {
		ModelAndView model = new ModelAndView();

		Risposta risposta = rispostaService.getAnswerById(id);
		model.addObject("risposteForm", risposta);
		model.setViewName("risposte_form");

		return model;
	}
	
	@RequestMapping(value="/startQuiz/{quizid}", method=RequestMethod.GET)
	public ModelAndView startQuiz(@PathVariable("quizid")long quizid,HttpSession httpsession) {
		
		ModelAndView model = new ModelAndView();
		Quiz quiz = quizService.getQuizById(quizid);
		String username = (String) httpsession.getAttribute("username");
		Utente utente = utenteService.getUtenteByUsername(username).get(0);
		List<Domanda> domande = domandaService.getAllDomandeByQuizId(quiz.getId());
		Map<String,List<Risposta>> mappaRisposte = new HashMap<String,List<Risposta>>();
		
		for(Domanda domanda : domande) {
			
			List<Risposta>risposte = rispostaService.getAllRispostebyDomandaId(domanda.getId());
			mappaRisposte.put(domanda.getTesto(),risposte);
		}
		
		model.addObject("questionList", domande);
		model.addObject("quiz",quiz);
		model.addObject("utente",utente);
		model.addObject("mappaRisposte",mappaRisposte);
		model.addObject("numDomande",domande.size());
		model.setViewName("start_quiz");

		return model;
		
	}
	
	@RequestMapping(value="/rispondi/{domandaid}", method=RequestMethod.GET)
	public ModelAndView rispondi(@PathVariable("domandaid")long domandaid) {
		ModelAndView model = new ModelAndView();
		
		Risposta risposta = new Risposta();
		Domanda domanda = domandaService.getQuestionById(domandaid);
		risposta.setDomanda(domanda);
		model.addObject("rispForm", risposta);
		model.setViewName("risp_form");

		return model;
		
	}
	
	@RequestMapping(value="/salvaR", method=RequestMethod.POST)
    public ModelAndView salvaR(@ModelAttribute("rispForm") Risposta risposta) {
        rispostaService.saveOrUpdate(risposta);
        Domanda domanda = domandaService.getQuestionById(risposta.getDomanda().getId());
        Quiz quiz = quizService.getQuizById(domanda.getQuiz().getId());
        return new ModelAndView("redirect:/quiz/startQuiz/" + quiz.getId());
    }
	
}