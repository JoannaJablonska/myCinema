package pl.training.mycinema.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommandHandler;
import pl.training.mycinema.application.inputs.queries.GetMovieCatalogQueryHandler;
import pl.training.mycinema.application.movie.MovieApplicationService;
import pl.training.mycinema.application.reservation.ReservationApplicationService;
import pl.training.mycinema.domain.movie.repositories.MovieRepository;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;
import pl.training.mycinema.domain.reservation.repositories.ReservationRepository;

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

	@Bean
	public ReservationApplicationService reservationApplicationService(final MovieRepository movieRepository,
			final ScreeningRepository screeningRepository, final ReservationRepository reservationRepository) {
		return new ReservationApplicationService(movieRepository, screeningRepository, reservationRepository);
	}

	@Bean
	public ReserveSeatsCommandHandler reserveSeatsCommandHandler(final ReservationApplicationService reservationApplicationService) {
		return new ReserveSeatsCommandHandler(reservationApplicationService);
	}
}
