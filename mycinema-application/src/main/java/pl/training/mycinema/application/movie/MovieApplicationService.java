package pl.training.mycinema.application.movie;

import java.util.List;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.repositories.MovieRepository;

@RequiredArgsConstructor
public class MovieApplicationService {

	private final MovieRepository movieRepository;

	public List<Movie> getMovieCatalog() {
		return movieRepository.getAll();
	}
}
