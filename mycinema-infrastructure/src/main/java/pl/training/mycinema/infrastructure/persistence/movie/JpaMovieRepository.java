package pl.training.mycinema.infrastructure.persistence.movie;

import org.springframework.data.repository.CrudRepository;

public interface JpaMovieRepository extends CrudRepository<MovieEntity, String> {

}
