package it.circuitoinformatico.service;

import java.util.List;
import it.circuitoinformatico.model.Utente;

public interface UtenteService {
	
	public List<Utente> getAllUsers();
	
	public List<Utente> getUtenteByUsername(String codice_utente);
	
	public List<Utente> getUtenteByUsernameAndPassword(String codice_utente,String password);

	public Utente getUtenteById(long id);

	public void saveOrUpdate(Utente utente);

	public void deleteUtente(long id);
}
