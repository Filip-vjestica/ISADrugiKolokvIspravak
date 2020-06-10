package drugiKolokv.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import drugiKolokv.app.model.Porudzbina;
import drugiKolokv.app.repository.PorudzbinaRepository;

@Service
public class PorudzbinaService {
	
	@Autowired
	PorudzbinaRepository porudzbinaRepository;
	
	public Iterable<Porudzbina> findAll(){
		return porudzbinaRepository.findAll();
		}
	
	public Iterable<Porudzbina> findAll(Pageable pageable){
		return porudzbinaRepository.findAll(pageable);
		
	}
	public Optional<Porudzbina> findOne(Long id){
		return porudzbinaRepository.findById(id);
		}
	
	public void remove(Long id){
		porudzbinaRepository.deleteById(id);
	}
	public Porudzbina save(Porudzbina Porudzbina){
		return porudzbinaRepository.save(Porudzbina);
	}

}
