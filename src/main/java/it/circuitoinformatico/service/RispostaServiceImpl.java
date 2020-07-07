package it.circuitoinformatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.circuitoinformatico.model.Risposta;
import it.circuitoinformatico.repository.RispostaRepository;

@Service
@Transactional
public class RispostaServiceImpl implements RispostaService {

	@Autowired
	RispostaRepository rispostaRepository;

	@Override
	public List<Risposta> getAllAnswers() {

		return (List<Risposta>) rispostaRepository.findAll();
	}

	@Override
	public List<Risposta> getAllRispostebyDomandaId(long domanda_id) {

		return (List<Risposta>) rispostaRepository.getAllRisposteByDomandaId(domanda_id);
	}

	@Override
	public Risposta getAnswerById(long id) {

		return rispostaRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Risposta risposta) {

		rispostaRepository.save(risposta);
	}

	@Override
	public void deleteAnswer(long id) {

		rispostaRepository.deleteById(id);

	}
}
