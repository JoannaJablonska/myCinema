package pl.training.mycinema.domain.movie.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Value;
import pl.training.mycinema.domain.reservation.model.Seat;

@Value
@Builder
public class Screening {

	String id;

	Movie movie;

	LocalDateTime time;

	List<Seat> seats;

	public boolean isAvailable(final Seat currentSeat) {
		return seats.stream()
				.anyMatch(seat -> isPresent(currentSeat, seat) && seat.isAvailable());
	}

	private static boolean isPresent(final Seat currentSeat, final Seat seat) {
		return seat.getRowNo() == currentSeat.getRowNo() && seat.getColumnNo() == currentSeat.getColumnNo();
	}
}
