package drugiKolokv.app.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Porudzbina {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String brojPorudzbine;
	
	private Long restoran;
	
	private LocalDateTime datumPorudzbine;
	
	private String status;
	
	@ManyToOne
	private Korisnik korisnik;
	
	@OneToMany(mappedBy = "porudzbina")
	private List<StavkaPorudzbine> stavkaPorudzbine;

	public Porudzbina() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Porudzbina(Long id, String brojPorudzbine, Long restoran, LocalDateTime datumPorudzbine, String status,
			Korisnik korisnik, List<StavkaPorudzbine> stavkaPorudzbine) {
		super();
		this.id = id;
		this.brojPorudzbine = brojPorudzbine;
		this.restoran = restoran;
		this.datumPorudzbine = datumPorudzbine;
		this.status = status;
		this.korisnik = korisnik;
		this.stavkaPorudzbine = stavkaPorudzbine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrojPorudzbine() {
		return brojPorudzbine;
	}

	public void setBrojPorudzbine(String brojPorudzbine) {
		this.brojPorudzbine = brojPorudzbine;
	}

	public Long getRestoran() {
		return restoran;
	}

	public void setRestoran(Long restoran) {
		this.restoran = restoran;
	}

	public LocalDateTime getDatumPorudzbine() {
		return datumPorudzbine;
	}

	public void setDatumPorudzbine(LocalDateTime datumPorudzbine) {
		this.datumPorudzbine = datumPorudzbine;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<StavkaPorudzbine> getStavkaPorudzbine() {
		return stavkaPorudzbine;
	}

	public void setStavkaPorudzbine(List<StavkaPorudzbine> stavkaPorudzbine) {
		this.stavkaPorudzbine = stavkaPorudzbine;
	}
	
	
	

}
