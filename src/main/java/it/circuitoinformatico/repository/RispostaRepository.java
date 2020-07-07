package it.circuitoinformatico.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.circuitoinformatico.model.Risposta;

public interface RispostaRepository extends CrudRepository<Risposta, Long>  {
	
	public List<Risposta> getAllRisposteByDomandaId(long domanda_id);

}
