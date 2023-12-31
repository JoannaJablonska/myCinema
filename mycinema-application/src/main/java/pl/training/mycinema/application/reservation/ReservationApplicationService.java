package pl.training.mycinema.application.reservation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommand;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.movie.repositories.MovieRepository;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;
import pl.training.mycinema.domain.reservation.model.Reservation;
import pl.training.mycinema.domain.reservation.model.ReservationLine;
import pl.training.mycinema.domain.reservation.model.Seat;
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

		List<ReservationLine> processedReservationLines = new ArrayList<>();

		for (final ReservationLine line : command.getReservationLines()) {
			final Optional<Seat> requestedSeat = findRequestedSeat(line.getSeat(), foundScreening.get().getSeats());
			if (requestedSeat.isPresent()) {
				processedReservationLines.add(ReservationLine.builder()
						.id(UUID.randomUUID().toString())
						.seat(requestedSeat.get())
						.discountType(line.getDiscountType())
						.build());
				requestedSeat.get().setAvailable(false);
			}
		}

		final Reservation reservation = Reservation.builder()
				.id(UUID.randomUUID().toString())
				.screening(foundScreening.get())
				.reservationLines(processedReservationLines)
				.paid(false)
				.active(true)
				.build();

		reservation.calculateTotalPrice();

		reservationRepository.save(reservation);

		return reservation;
	}

	public Optional<Reservation> getReservationById(final String id) {
		return reservationRepository.getById(id);
	}

	public void payForReservation(final String id) {
		final Optional<Reservation> reservation = reservationRepository.getById(id);
		if (reservation.isEmpty()) {
			throw new RuntimeException(String.format("Reservation with id %s was not found", id));
		}
		reservation.get().payForReservation();
		reservationRepository.save(reservation.get());
	}

	public void cancelReservation(final String id) {
		final Optional<Reservation> reservation = reservationRepository.getById(id);
		if (reservation.isEmpty()) {
			throw new RuntimeException(String.format("Reservation with id %s was not found", id));
		}
		reservation.get().cancelReservation();
		reservationRepository.save(reservation.get());
	}

	private Optional<Seat> findRequestedSeat(final Seat seat, final List<Seat> seats) {
		return seats.stream()
				.filter(currentSeat -> isSameSeat(seat, currentSeat))
				.findFirst();
	}

	private static boolean isSameSeat(final Seat seat, final Seat currentSeat) {
		return currentSeat.getRowNo() == seat.getRowNo()
				&& currentSeat.getColumnNo() == seat.getColumnNo()
				&& currentSeat.getHallNo() == seat.getHallNo();
	}

	private static boolean areSeatsAvailable(final ReserveSeatsCommand command, final Screening foundScreening) {
		return command.getReservationLines().stream()
				.map(ReservationLine::getSeat)
				.allMatch(foundScreening::isAvailable);
	}
}
