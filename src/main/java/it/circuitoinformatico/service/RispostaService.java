package it.circuitoinformatico.service;

import java.util.List;
import it.circuitoinformatico.model.Risposta;

public interface RispostaService {
	
	public List<Risposta> getAllAnswers();
		
	public List<Risposta> getAllRispostebyDomandaId(long domanda_id);

	public Risposta getAnswerById(long id);

	public void saveOrUpdate(Risposta risposta);

	public void deleteAnswer(long id);
}
