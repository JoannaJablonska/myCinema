package pl.training.mycinema.infrastructure.ui.rest.reservation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommand;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommandHandler;
import pl.training.mycinema.domain.reservation.model.Reservation;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationResource {

	private final ReserveSeatsCommandHandler reserveSeatsCommandHandler;

	private final PresentationalReservationMapper presentationalReservationMapper;

	@PostMapping
	public ResponseEntity<PresentationalReservation> reserveSeats(@RequestBody ReserveSeatsCommand reserveSeatsCommand) {
		final Reservation reservation = reserveSeatsCommandHandler.handle(reserveSeatsCommand);
		return ResponseEntity.ok(presentationalReservationMapper.toPresentational(reservation));
	}
}
