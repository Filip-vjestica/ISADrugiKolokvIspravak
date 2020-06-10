package drugiKolokv.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StavkaPorudzbine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private Double cena;
	
	@ManyToOne
	private Porudzbina porudzbina;

	public StavkaPorudzbine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StavkaPorudzbine(long id, String naziv, Double cena, Porudzbina porudzbina) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.porudzbina = porudzbina;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}
	
	

}
