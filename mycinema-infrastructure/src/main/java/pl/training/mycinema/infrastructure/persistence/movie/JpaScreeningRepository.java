package pl.training.mycinema.infrastructure.persistence.movie;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface JpaScreeningRepository extends CrudRepository<ScreeningEntity, String> {

	Optional<ScreeningEntity> findByTimeAndMovieName(LocalDateTime time, String movieName);
	List<ScreeningEntity> findByMovieName(String movieName);
}
