package drugiKolokv.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import drugiKolokv.app.dto.PorudzbinaDTO;
import drugiKolokv.app.model.Porudzbina;
import drugiKolokv.app.service.PorudzbinaService;

@Controller
@RequestMapping(path = "api/porudzbina")
public class PorudzbinaController {
	
	@Autowired
	PorudzbinaService porudzbinaService;

	@RequestMapping(path = "/dobavi-sve", method = RequestMethod.GET)
	@Secured("ROLE_KORISNIK")
	public ResponseEntity<Iterable<PorudzbinaDTO>> getAll() {
		ArrayList<PorudzbinaDTO> result = new ArrayList<PorudzbinaDTO>();
		for (Porudzbina r:porudzbinaService.findAll()) {
			result.add(new PorudzbinaDTO());
		}
		return new ResponseEntity<Iterable<PorudzbinaDTO>>(result, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Porudzbina>> getOne(@PathVariable("id") Long id) {
		Optional<Porudzbina> k = porudzbinaService.findOne(id);
		if (k == null)
			return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Optional<Porudzbina>>(k,HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<PorudzbinaDTO> save(@RequestBody() Porudzbina n) {
		return new ResponseEntity<PorudzbinaDTO>(new PorudzbinaDTO(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Porudzbina> remove(@PathVariable("id") Long id) {
		Optional<Porudzbina> n = porudzbinaService.findOne(id);
		if (n == null) {
			return new ResponseEntity<Porudzbina>(HttpStatus.NOT_FOUND);
		}
		porudzbinaService.remove(id);
		return new ResponseEntity<Porudzbina>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ResponseEntity<Optional<Porudzbina>> edit(@RequestBody() Porudzbina n) {
		Optional<Porudzbina> Porudzbina = porudzbinaService.findOne(n.getId());
		if (Porudzbina == null) {
			return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.NOT_FOUND);
		}
		porudzbinaService.save(n);
		return new ResponseEntity<Optional<Porudzbina>>(HttpStatus.OK);
	}

}
