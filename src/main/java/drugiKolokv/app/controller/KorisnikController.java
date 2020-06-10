package drugiKolokv.app.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import drugiKolokv.app.model.Korisnik;
import drugiKolokv.app.model.KorisnikRola;
import drugiKolokv.app.repository.KorisnikRepository;
import drugiKolokv.app.service.KorisnikService;
import drugiKolokv.app.utils.TokenUtils;

@Controller
@RequestMapping("/api/korisnik")
public class KorisnikController {
	
	@Autowired
	KorisnikService korisnikService;

	@Autowired
	KorisnikRepository korisnikRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/dobavi-sve", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Korisnik>> dobaviKorisnike() {
		return new ResponseEntity<Iterable<Korisnik>>(korisnikService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Korisnik>> dobaviKorisnika(@PathVariable("id") Long id) {
		Optional<Korisnik> n = korisnikService.findOne(id);
		if (n != null)
			return new ResponseEntity<Optional<Korisnik>>(n, HttpStatus.OK);
		else
			return new ResponseEntity<Optional<Korisnik>>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<Korisnik> save(@RequestBody() Korisnik n) {
		korisnikService.save(n);
		return new ResponseEntity<Korisnik>(n, HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Korisnik> remove(@PathVariable("id") Long id) {
		Optional<Korisnik> n = korisnikService.findOne(id);
		if (n == null) {
			return new ResponseEntity<Korisnik>(HttpStatus.NOT_FOUND);
		}
		korisnikService.remove(id);
		return new ResponseEntity<Korisnik>(HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ResponseEntity<Optional<Korisnik>> edit(@RequestBody() Korisnik n) {
		Optional<Korisnik> Korisnik = korisnikService.findOne(n.getId());
		if (Korisnik == null) {
			return new ResponseEntity<Optional<Korisnik>>(HttpStatus.NOT_FOUND);
		}
		korisnikService.save(n);
		return new ResponseEntity<Optional<Korisnik>>(HttpStatus.OK);
	}
	
	 @RequestMapping(path = "/register", method = RequestMethod.POST)
	    public ResponseEntity<String> register(
		    @RequestBody Korisnik korisnik) {

		 korisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));

		this.korisnikService.save(korisnik);
		korisnik.setKorisnikRole(new HashSet<KorisnikRola>());


		this.korisnikService.save(korisnik);

		return new ResponseEntity<String>(korisnik.getUsername(), HttpStatus.OK);
	    }
	

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody Korisnik korisnik) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(korisnik.getUsername(),
					korisnik.getPassword());
			
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(korisnik.getUsername().toString());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(path = "/test" ,method = RequestMethod.GET)
	@Secured("ROLE_KORISNIK")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}

}
