package it.circuitoinformatico.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="domanda")
public class Domanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="testo")
	private String testo;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) // Fetch type lazy effettua il lazy-loading dell'entity quiz(ovvero viene caricata nella pagina solo quando necessaria).
	@JoinColumn(name = "quiz_id" , nullable = false) // nullable = false si assicura che il campo non sia vuoto,cascadeType.ALL cancella,a cascata,le domande relative al quiz rimosso.
	private Quiz quiz; // ManyToOne specifica il tipo di relazione tra tabelle,N ad Uno,Join Column specifica quale colonna della tabella Quiz contiene la foreign key.
	
	@OneToMany(mappedBy = "domanda", cascade = CascadeType.ALL)
	private Set<Risposta> risposte;

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

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Set<Risposta> getRisposte() {
		return risposte;
	}

	public void setRisposte(Set<Risposta> risposte) {
		this.risposte = risposte;
	}
}