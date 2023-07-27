package pl.training.mycinema.infrastructure.persistence.movie;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface JpaMovieRepository extends CrudRepository<MovieEntity, String> {

	Optional<MovieEntity> findByName(String name);
}
