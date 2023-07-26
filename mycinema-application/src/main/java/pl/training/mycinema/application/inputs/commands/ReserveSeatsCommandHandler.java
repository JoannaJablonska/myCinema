package pl.training.mycinema.application.inputs.commands;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.reservation.ReservationApplicationService;
import pl.training.mycinema.domain.reservation.model.Reservation;

@RequiredArgsConstructor
public class ReserveSeatsCommandHandler {

	private final ReservationApplicationService reservationApplicationService;

	public Reservation handle(final ReserveSeatsCommand reserveSeatsCommand) {
		return reservationApplicationService.reserveSeats(reserveSeatsCommand);
	}
}
