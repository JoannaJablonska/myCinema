package pl.training.mycinema.infrastructure.persistence.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.repositories.MovieRepository;

@Primary
@Transactional
@Repository
@RequiredArgsConstructor
public class JpaMovieRepositoryAdapter implements MovieRepository {

	private final JpaMovieRepository movieRepository;

	private final MovieEntityMapper mapper;

	@Override
	public List<Movie> getAll() {
		return mapper.toMultipleMovies(movieRepository.findAll());
	}

	@Override
	public Optional<Movie> findByName(final String name) {
		return movieRepository.findByName(name)
				.map(mapper::toMovie);
	}
}
