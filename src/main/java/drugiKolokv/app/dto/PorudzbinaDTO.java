package drugiKolokv.app.dto;

import java.time.LocalDateTime;

public class PorudzbinaDTO {
	private long id;
	private String brojPorudzbine;
	private long restoran;
	private LocalDateTime datumPorudzbine;
	private String status;
	private StavkaPorudzbineDTO stavkaPorudzbineDTO;
	public PorudzbinaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PorudzbinaDTO(long id, String brojPorudzbine, long restoran, LocalDateTime datumPorudzbine, String status,
			StavkaPorudzbineDTO stavkaPorudzbineDTO) {
		super();
		this.id = id;
		this.brojPorudzbine = brojPorudzbine;
		this.restoran = restoran;
		this.datumPorudzbine = datumPorudzbine;
		this.status = status;
		this.stavkaPorudzbineDTO = stavkaPorudzbineDTO;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrojPorudzbine() {
		return brojPorudzbine;
	}
	public void setBrojPorudzbine(String brojPorudzbine) {
		this.brojPorudzbine = brojPorudzbine;
	}
	public long getRestoran() {
		return restoran;
	}
	public void setRestoran(long restoran) {
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
	public StavkaPorudzbineDTO getStavkaPorudzbineDTO() {
		return stavkaPorudzbineDTO;
	}
	public void setStavkaPorudzbineDTO(StavkaPorudzbineDTO stavkaPorudzbineDTO) {
		this.stavkaPorudzbineDTO = stavkaPorudzbineDTO;
	}
	
	

}
