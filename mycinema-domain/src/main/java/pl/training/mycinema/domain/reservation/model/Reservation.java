package pl.training.mycinema.domain.reservation.model;

import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import pl.training.mycinema.domain.movie.model.Screening;

@Getter
@EqualsAndHashCode
@ToString
@Builder
public class Reservation {

	String id;

	Screening screening;

	List<ReservationLine> reservationLines;

	boolean paid;

	double totalPrice;

	boolean active;

	public void calculateTotalPrice() {
		totalPrice = reservationLines.stream()
				.mapToDouble(this::calculateLinePrice)
				.sum();
	}

	private double calculateLinePrice(final ReservationLine line) {
		return line.getDiscountType().getDiscountPercentage() * line.getSeat().getPrice() / 100.00;
	}

	public void payForReservation() {
		paid = true;
	}

	public void cancelReservation() {
		active = false;
		reservationLines.forEach(line -> line.getSeat().setAvailable(true));
		screening.getSeats().stream()
				.filter(this::isSeatFromReservation)
				.forEach(seat -> seat.setAvailable(true));
	}

	private boolean isSeatFromReservation(final Seat seat) {
		return reservationLines.stream()
				.map(ReservationLine::getSeat)
				.anyMatch(currentSeat -> currentSeat.getRowNo() == seat.getRowNo()
						&& currentSeat.getColumnNo() == seat.getColumnNo()
						&& currentSeat.getHallNo() == seat.getHallNo());
	}
}
