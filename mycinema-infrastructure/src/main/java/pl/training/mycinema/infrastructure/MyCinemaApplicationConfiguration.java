package pl.training.mycinema.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.training.mycinema.application.inputs.commands.CancelReservationCommandHandler;
import pl.training.mycinema.application.inputs.commands.PayForReservationCommandHandler;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommandHandler;
import pl.training.mycinema.application.inputs.queries.GetMovieCatalogQueryHandler;
import pl.training.mycinema.application.inputs.queries.GetReservationQueryHandler;
import pl.training.mycinema.application.inputs.queries.GetScreeningsQueryHandler;
import pl.training.mycinema.application.inputs.queries.GetSeatsQueryHandler;
import pl.training.mycinema.application.movie.MovieApplicationService;
import pl.training.mycinema.application.reservation.ReservationApplicationService;
import pl.training.mycinema.application.screening.ScreeningApplicationService;
import pl.training.mycinema.application.seat.SeatApplicationService;
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
	public SeatApplicationService seatApplicationService(final ScreeningRepository repository) {
		return new SeatApplicationService(repository);
	}

	@Bean
	public ScreeningApplicationService screeningApplicationService(final ScreeningRepository repository) {
		return new ScreeningApplicationService(repository);
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

	@Bean
	public GetReservationQueryHandler getReservationQueryHandler(final ReservationApplicationService reservationApplicationService) {
		return new GetReservationQueryHandler(reservationApplicationService);
	}

	@Bean
	public PayForReservationCommandHandler payForReservationCommandHandler(final ReservationApplicationService reservationApplicationService) {
		return new PayForReservationCommandHandler(reservationApplicationService);
	}

	@Bean
	public CancelReservationCommandHandler cancelReservationCommandHandler(final ReservationApplicationService reservationApplicationService) {
		return new CancelReservationCommandHandler(reservationApplicationService);
	}

	@Bean
	public GetScreeningsQueryHandler getScreeningsQueryHandler(final ScreeningApplicationService screeningApplicationService) {
		return new GetScreeningsQueryHandler(screeningApplicationService);
	}

	@Bean
	public GetSeatsQueryHandler getSeatsQueryHandler(final SeatApplicationService seatApplicationService) {
		return new GetSeatsQueryHandler(seatApplicationService);
	}
}
