package pl.training.mycinema.application.reservation;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommand;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.movie.repositories.MovieRepository;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;
import pl.training.mycinema.domain.reservation.model.Reservation;
import pl.training.mycinema.domain.reservation.model.ReservationLines;
import pl.training.mycinema.domain.reservation.repositories.ReservationRepository;

@RequiredArgsConstructor
public class ReservationApplicationService {

	private final MovieRepository movieRepository;

	private final ScreeningRepository screeningRepository;

	private final ReservationRepository reservationRepository;

	public Reservation reserveSeats(final ReserveSeatsCommand command) {
		final Optional<Movie> foundMovie = movieRepository.findByName(command.getMovieName());
		if (foundMovie.isEmpty()) {
			throw new RuntimeException("Movie not found");
		}

		final Optional<Screening> foundScreening = screeningRepository.findByMovieAndTime(foundMovie.get(), command.getTime());
		if (foundScreening.isEmpty()) {
			throw new RuntimeException("Screening not found");
		}

		if (!areSeatsAvailable(command, foundScreening.get())) {
			throw new RuntimeException("Seats are not available");
		}

		final Reservation reservation = Reservation.builder()
				.screening(foundScreening.get())
				.reservationLines(command.getReservationLines())
				.build();

		reservationRepository.save(reservation);

		return null;
	}

	private static boolean areSeatsAvailable(final ReserveSeatsCommand command, final Screening foundScreening) {
		return command.getReservationLines().stream()
				.map(ReservationLines::getSeat)
				.allMatch(foundScreening::isAvailable);
	}
}
