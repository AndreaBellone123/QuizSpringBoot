package it.circuitoinformatico.repository;

import org.springframework.data.repository.CrudRepository;

import it.circuitoinformatico.model.Quiz;

public interface QuizRepository extends CrudRepository<Quiz, Long>  {

}
