package pl.training.mycinema.infrastructure.persistence.movie;


import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.Movie;
import pl.training.mycinema.domain.movie.MovieRepository;
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
}
