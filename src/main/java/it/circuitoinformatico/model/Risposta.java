package it.circuitoinformatico.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="risposta")
public class Risposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="testo")
	private String testo;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) // Fetch type lazy effettua il lazy-loading dell'entity quiz(ovvero viene caricata nella pagina solo quando necessaria)
	@JoinColumn(name = "domanda_id" , nullable = false) // nullable = false si assicura che il campo non sia vuoto,cascadeType.ALL cancella,a cascata,le risposte relative alla domanda eliminata.
	private Domanda domanda; // ManyToOne specifica il tipo di relazione tra tabelle,N ad Uno,Join Column specifica quale colonna della tabella Domanda contiene la foreign key.

	@Column(name="corretto")
	private boolean corretto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public boolean isCorretto() {
		return corretto;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}

	public Domanda getDomanda() {
		return domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}
	
}