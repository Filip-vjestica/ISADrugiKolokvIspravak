package drugiKolokv.app.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import drugiKolokv.app.model.Korisnik;
import drugiKolokv.app.repository.KorisnikRepository;

@Service
public class KorisnikService {
	
	@Autowired
	KorisnikRepository korisnikRepository;
	
	public Iterable<Korisnik> findAll(){
		return korisnikRepository.findAll();
		}
	
	public Iterable<Korisnik> findAll(Pageable pageable){
		return korisnikRepository.findAll(pageable);
		
	}
	public Optional<Korisnik> findOne(Long id){
		return korisnikRepository.findById(id);
		}
	
	public void remove(Long id){
		korisnikRepository.deleteById(id);
	}
	public Korisnik save(Korisnik Korisnik){
		return korisnikRepository.save(Korisnik);
	}
	
	//security
	public Optional<Korisnik> getKorisnik(String username) {
		return korisnikRepository.getByUsername(username);
	}
	
	public Optional<Korisnik> getUser(String username, String password) {
		return korisnikRepository.getByUsernameAndPassword(username, password);
	}

}
