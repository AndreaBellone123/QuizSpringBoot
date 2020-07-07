package it.circuitoinformatico.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.circuitoinformatico.model.Utente;


public interface UtenteRepository extends CrudRepository<Utente,Long> {
	
	public List<Utente> getUtenteByUsername(String codice_utente);
	public List<Utente> getUtenteByUsernameAndPassword(String codice_utente,String password);

}
