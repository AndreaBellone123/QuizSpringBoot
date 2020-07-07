package it.circuitoinformatico.service;

import java.util.List;
import it.circuitoinformatico.model.Domanda;

public interface DomandaService {
	
	public List<Domanda> getAllQuestions();
	
	public List<Domanda> getAllDomandeByQuizId(long quiz_id);

	public Domanda getQuestionById(long id);

	public void saveOrUpdate(Domanda domanda);

	public void deleteQuestion(long id);
	
}
