package pl.training.mycinema.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.training.mycinema.application.inputs.queries.GetMovieCatalogQueryHandler;
import pl.training.mycinema.application.movie.MovieApplicationService;
import pl.training.mycinema.domain.movie.MovieRepository;

@Configuration
public class MyCinemaApplicationConfiguration {

	@Bean
	public MovieApplicationService movieApplicationService(final MovieRepository repository) {
		return new MovieApplicationService(repository);
	}

	@Bean
	public GetMovieCatalogQueryHandler getMovieCatalogQueryHandler(final MovieApplicationService movieApplicationService) {
		return new GetMovieCatalogQueryHandler(movieApplicationService);
	}
}
