package pl.training.mycinema.infrastructure.ui.rest.movie;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.inputs.queries.GetMovieCatalogQuery;
import pl.training.mycinema.application.inputs.queries.GetMovieCatalogQueryHandler;
import pl.training.mycinema.domain.movie.model.Movie;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieResource {

	private final GetMovieCatalogQueryHandler getMovieCatalogQueryHandler;

	private final PresentationalMovieMapper presentationalMovieMapper;

	@GetMapping
	public List<PresentationalMovie> getMovies() {
		final List<Movie> queryResults = getMovieCatalogQueryHandler.handle(new GetMovieCatalogQuery());
		return presentationalMovieMapper.toPresentational(queryResults);
	}
}
