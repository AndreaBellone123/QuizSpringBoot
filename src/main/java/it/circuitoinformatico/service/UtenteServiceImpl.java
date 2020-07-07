package it.circuitoinformatico.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.circuitoinformatico.model.Utente;
import it.circuitoinformatico.repository.UtenteRepository;

@Service
@Transactional
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	UtenteRepository utenteRepository;

	@Override
	public List<Utente> getAllUsers() {
		return (List<Utente>) utenteRepository.findAll();
	}

	@Override
	public Utente getUtenteById(long id) {
		return utenteRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Utente utente) {
		
		utenteRepository.save(utente);
		
	}

	@Override
	public void deleteUtente(long id) {
		
		utenteRepository.deleteById(id);
	}

	@Override
	public List<Utente> getUtenteByUsername(String codice_utente) {
		
		return utenteRepository.getUtenteByUsername(codice_utente);
	}

	@Override
	public List<Utente> getUtenteByUsernameAndPassword(String codice_utente, String password) {
	
		return utenteRepository.getUtenteByUsernameAndPassword(codice_utente, password);
	}



	
}
