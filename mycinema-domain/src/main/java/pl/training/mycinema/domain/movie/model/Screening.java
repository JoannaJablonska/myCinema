package pl.training.mycinema.domain.movie.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Value;
import pl.training.mycinema.domain.reservation.model.Seat;

@Value
public class Screening {

	Movie movie;

	LocalDateTime time;

	List<Seat> seats;

	public boolean isAvailable(final Seat currentSeat) {
		return seats.stream()
				.anyMatch(seat -> isPresent(currentSeat, seat) && seat.isAvailable());
	}

	private static boolean isPresent(final Seat currentSeat, final Seat seat) {
		return seat.getRow() == currentSeat.getRow() && seat.getColumn() == currentSeat.getColumn();
	}
}
