package drugiKolokv.app.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import drugiKolokv.app.model.Korisnik;
import drugiKolokv.app.model.KorisnikRola;

@Service
public class KorisnikDetailsServiceImpl {
	
	@Autowired
	KorisnikService korisnikService;
	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Korisnik> korisnik = korisnikService.getKorisnik(username);
		
		if (korisnik.isPresent()) {
		    ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		    for (KorisnikRola korisnikRola : korisnik.get().getKorisnikRole()) {
			
			grantedAuthorities.add(new SimpleGrantedAuthority(korisnikRola.getRola().getTitle()));
		    }

		    return new org.springframework.security.core.userdetails.User(korisnik.get().getUsername().toString(),
			    korisnik.get().getPassword(), grantedAuthorities);
		}
		

		return null;
	    }

}
