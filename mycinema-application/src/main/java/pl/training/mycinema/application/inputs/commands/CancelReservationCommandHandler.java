package pl.training.mycinema.application.inputs.commands;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.reservation.ReservationApplicationService;

@RequiredArgsConstructor
public class CancelReservationCommandHandler {

	private final ReservationApplicationService reservationApplicationService;

	public void handle(CancelReservationCommand command) {
		reservationApplicationService.cancelReservation(command.getId());
	}
}
