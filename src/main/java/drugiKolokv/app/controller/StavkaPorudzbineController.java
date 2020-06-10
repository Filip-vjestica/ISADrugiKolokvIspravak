package drugiKolokv.app.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import drugiKolokv.app.dto.StavkaPorudzbineDTO;
import drugiKolokv.app.model.StavkaPorudzbine;
import drugiKolokv.app.service.StavkaPorudzbineService;

@Controller
@RequestMapping(path = "api/stavka-porudzbine")
public class StavkaPorudzbineController {

	@Autowired
	StavkaPorudzbineService stavkaPorudzbineService;

	@RequestMapping(path = "/dobavi-sve", method = RequestMethod.GET)
	public ResponseEntity<Iterable<StavkaPorudzbineDTO>> getAll() {
		ArrayList<StavkaPorudzbineDTO> result = new ArrayList<StavkaPorudzbineDTO>();
		for (StavkaPorudzbine r:stavkaPorudzbineService.findAll()) {
			result.add(new StavkaPorudzbineDTO());
		}
		return new ResponseEntity<Iterable<StavkaPorudzbineDTO>>(result, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<StavkaPorudzbine>> getOne(@PathVariable("id") Long id) {
		Optional<StavkaPorudzbine> k = stavkaPorudzbineService.findOne(id);
		if (k == null)
			return new ResponseEntity<Optional<StavkaPorudzbine>>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Optional<StavkaPorudzbine>>(k,HttpStatus.OK);
	}

	@RequestMapping(path = "", method = RequestMethod.POST)
	public ResponseEntity<StavkaPorudzbineDTO> save(@RequestBody() StavkaPorudzbine n) {
		return new ResponseEntity<StavkaPorudzbineDTO>(new StavkaPorudzbineDTO(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StavkaPorudzbine> remove(@PathVariable("id") Long id) {
		Optional<StavkaPorudzbine> n = stavkaPorudzbineService.findOne(id);
		if (n == null) {
			return new ResponseEntity<StavkaPorudzbine>(HttpStatus.NOT_FOUND);
		}
		stavkaPorudzbineService.remove(id);
		return new ResponseEntity<StavkaPorudzbine>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "", method = RequestMethod.PUT)
	public ResponseEntity<Optional<StavkaPorudzbine>> edit(@RequestBody() StavkaPorudzbine n) {
		Optional<StavkaPorudzbine> stavkaPorudzbine = stavkaPorudzbineService.findOne(n.getId());
		if (stavkaPorudzbine == null) {
			return new ResponseEntity<Optional<StavkaPorudzbine>>(HttpStatus.NOT_FOUND);
		}
		stavkaPorudzbineService.save(n);
		return new ResponseEntity<Optional<StavkaPorudzbine>>(HttpStatus.OK);
	}
}
