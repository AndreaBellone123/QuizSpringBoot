package it.circuitoinformatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.circuitoinformatico.model.Quiz;
import it.circuitoinformatico.repository.QuizRepository;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizRepository quizRepository;

	@Override
	public List<Quiz> getAllQuizzes() {
		return (List<Quiz>) quizRepository.findAll();
	}

	@Override
	public Quiz getQuizById(long id) {

		return quizRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Quiz quiz) {

		quizRepository.save(quiz);

	}

	@Override
	public void deleteQuiz(long id) {

		quizRepository.deleteById(id);

	}
}
