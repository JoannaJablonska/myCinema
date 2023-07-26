package pl.training.mycinema.domain.movie.repositories;

import java.util.List;
import java.util.Optional;

import pl.training.mycinema.domain.movie.model.Movie;

public interface MovieRepository {

	List<Movie> getAll();

	Optional<Movie> findByName(String name);
}
