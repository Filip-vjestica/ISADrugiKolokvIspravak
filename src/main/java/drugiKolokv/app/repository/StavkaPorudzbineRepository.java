package drugiKolokv.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import drugiKolokv.app.model.StavkaPorudzbine;

@Repository
public interface StavkaPorudzbineRepository extends PagingAndSortingRepository<StavkaPorudzbine, Long> {

}
