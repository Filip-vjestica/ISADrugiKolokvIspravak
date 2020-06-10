package drugiKolokv.app.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Korisnik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, columnDefinition = "text")
	private String username;
	
	@Column(nullable = false, columnDefinition = "text")
	private String password;
	
	@OneToMany(mappedBy = "korisnik")
	private List<Porudzbina> porudzbina;
	
	@OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private Set<KorisnikRola> korisnikRole;

	public Korisnik() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korisnik(long id, String username, String password, List<Porudzbina> porudzbina,
			Set<KorisnikRola> korisnikRole) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.porudzbina = porudzbina;
		this.korisnikRole = korisnikRole;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Porudzbina> getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(List<Porudzbina> porudzbina) {
		this.porudzbina = porudzbina;
	}

	public Set<KorisnikRola> getKorisnikRole() {
		return korisnikRole;
	}

	public void setKorisnikRole(Set<KorisnikRola> korisnikRole) {
		this.korisnikRole = korisnikRole;
	}
	
	
	
	

}
