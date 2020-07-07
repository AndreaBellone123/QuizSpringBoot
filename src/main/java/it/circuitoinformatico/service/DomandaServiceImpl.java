package it.circuitoinformatico.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.circuitoinformatico.model.Domanda;
import it.circuitoinformatico.repository.DomandaRepository;

@Service
@Transactional
public class DomandaServiceImpl implements DomandaService {

	@Autowired
	DomandaRepository domandaRepository;

	@Override
	public List<Domanda> getAllQuestions() {

		return (List<Domanda>) domandaRepository.findAll();
	}


	@Override
	public Domanda getQuestionById(long id) {

		return domandaRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Domanda domanda) {

		domandaRepository.save(domanda);

	}

	@Override
	public void deleteQuestion(long id) {

		domandaRepository.deleteById(id);

	}


	@Override
	public List<Domanda> getAllDomandeByQuizId(long quiz_id) {
		
		return (List<Domanda>) domandaRepository.getAllDomandeByQuizId(quiz_id);
	}

}
