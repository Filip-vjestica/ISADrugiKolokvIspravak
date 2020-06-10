package drugiKolokv.app.dto;

public class StavkaPorudzbineDTO {
	
	private long id;
	private String naziv;
	private Double cena;
	public StavkaPorudzbineDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StavkaPorudzbineDTO(long id, String naziv, Double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
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
	
	

}
