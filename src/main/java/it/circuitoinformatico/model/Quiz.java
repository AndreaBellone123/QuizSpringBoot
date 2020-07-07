package it.circuitoinformatico.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="titolo")
	private String titolo;

	@Column(name="tempo")
	private long tempo;
	
	@Column(name="codice_autore")
	private String codice_autore;
	
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private Set<Domanda> domande;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTempo() {
		return tempo;
	}

	public void setTempo(long tempo) {
		this.tempo = tempo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getCodice_autore() {
		return codice_autore;
	}

	public void setCodice_autore(String codice_autore) {
		this.codice_autore = codice_autore;
	}

	public Set<Domanda> getDomande() {
		return domande;
	}

	public void setDomande(Set<Domanda> domande) {
		this.domande = domande;
	}
	
}