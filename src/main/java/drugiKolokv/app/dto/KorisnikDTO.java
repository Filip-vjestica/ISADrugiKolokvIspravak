package drugiKolokv.app.dto;

public class KorisnikDTO {
	
	private long id;
	private String username;
	private String password;
	private PorudzbinaDTO porudzbinaDTO;
	
	
	public KorisnikDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public KorisnikDTO(long id, String username, String password, PorudzbinaDTO porudzbinaDTO) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.porudzbinaDTO = porudzbinaDTO;
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


	public PorudzbinaDTO getPorudzbinaDTO() {
		return porudzbinaDTO;
	}


	public void setPorudzbinaDTO(PorudzbinaDTO porudzbinaDTO) {
		this.porudzbinaDTO = porudzbinaDTO;
	}
	
	
	
	

}
