package it.circuitoinformatico.service;

import java.util.List;
import it.circuitoinformatico.model.Quiz;

public interface QuizService {
	
	public List<Quiz> getAllQuizzes();

	public Quiz getQuizById(long id);

	public void saveOrUpdate(Quiz quiz);

	public void deleteQuiz(long id);
		
}
