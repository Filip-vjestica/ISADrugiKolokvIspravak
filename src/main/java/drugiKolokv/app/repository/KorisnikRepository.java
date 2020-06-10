package drugiKolokv.app.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import drugiKolokv.app.model.Korisnik;

@Repository
public interface KorisnikRepository extends PagingAndSortingRepository<Korisnik, Long>{
	Optional<Korisnik> getByUsername(String username);
	Optional<Korisnik> getByUsernameAndPassword(String username, String password);

}
