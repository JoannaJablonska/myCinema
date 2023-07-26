package pl.training.mycinema.application.inputs.queries;

import java.util.List;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.movie.MovieApplicationService;
import pl.training.mycinema.domain.movie.model.Movie;

@RequiredArgsConstructor
public class GetMovieCatalogQueryHandler {

	private final MovieApplicationService movieApplicationService;

	public List<Movie> handle(GetMovieCatalogQuery query) {
		return movieApplicationService.getMovieCatalog();
	}
}
