package drugiKolokv.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import drugiKolokv.app.model.StavkaPorudzbine;
import drugiKolokv.app.repository.StavkaPorudzbineRepository;

@Service
public class StavkaPorudzbineService {
	
	@Autowired
	StavkaPorudzbineRepository stavkaPorudzbineRepository;
	
	public Iterable<StavkaPorudzbine> findAll(){
		return stavkaPorudzbineRepository.findAll();
		}
	
	public Iterable<StavkaPorudzbine> findAll(Pageable pageable){
		return stavkaPorudzbineRepository.findAll(pageable);
		
	}
	public Optional<StavkaPorudzbine> findOne(Long id){
		return stavkaPorudzbineRepository.findById(id);
		}
	
	public void remove(Long id){
		stavkaPorudzbineRepository.deleteById(id);
	}
	public StavkaPorudzbine save(StavkaPorudzbine StavkaPorudzbine){
		return stavkaPorudzbineRepository.save(StavkaPorudzbine);
	}

}
