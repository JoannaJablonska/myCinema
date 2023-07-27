package pl.training.mycinema.application.inputs.commands;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.reservation.ReservationApplicationService;

@RequiredArgsConstructor
public class PayForReservationCommandHandler {

	private final ReservationApplicationService reservationApplicationService;

	public void handle(PayForReservationCommand command) {
		reservationApplicationService.payForReservation(command.getId());
	}
}
