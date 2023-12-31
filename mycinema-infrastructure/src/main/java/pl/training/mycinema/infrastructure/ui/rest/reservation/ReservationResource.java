package pl.training.mycinema.infrastructure.ui.rest.reservation;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.inputs.commands.CancelReservationCommand;
import pl.training.mycinema.application.inputs.commands.CancelReservationCommandHandler;
import pl.training.mycinema.application.inputs.commands.PayForReservationCommand;
import pl.training.mycinema.application.inputs.commands.PayForReservationCommandHandler;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommand;
import pl.training.mycinema.application.inputs.commands.ReserveSeatsCommandHandler;
import pl.training.mycinema.application.inputs.queries.GetReservationQuery;
import pl.training.mycinema.application.inputs.queries.GetReservationQueryHandler;
import pl.training.mycinema.domain.reservation.model.Reservation;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class ReservationResource {

	private final ReserveSeatsCommandHandler reserveSeatsCommandHandler;

	private final PresentationalReservationMapper presentationalReservationMapper;

	private final GetReservationQueryHandler getReservationQueryHandler;

	private final PayForReservationCommandHandler payForReservationCommandHandler;

	private final CancelReservationCommandHandler cancelReservationCommandHandler;

	@PostMapping
	public ResponseEntity<PresentationalReservation> reserveSeats(@RequestBody ReserveSeatsCommand reserveSeatsCommand) {
		final Reservation reservation = reserveSeatsCommandHandler.handle(reserveSeatsCommand);
		return ResponseEntity.ok(presentationalReservationMapper.toPresentational(reservation));
	}

	@GetMapping("/{reservationId}")
	public ResponseEntity<PresentationalReservation> getReservation(@PathVariable String reservationId) {
		final Optional<Reservation> reservation = getReservationQueryHandler.handle(new GetReservationQuery(reservationId));

		return reservation
				.map(value -> ResponseEntity.ok(presentationalReservationMapper.toPresentational(value)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{reservationId}/pay")
	public ResponseEntity<Void> payForReservation(@PathVariable String reservationId) {
		payForReservationCommandHandler.handle(new PayForReservationCommand(reservationId));
		return ResponseEntity.accepted().build();
	}

	@PutMapping("/{reservationId}/cancel")
	public ResponseEntity<Void> cancelReservation(@PathVariable String reservationId) {
		cancelReservationCommandHandler.handle(new CancelReservationCommand(reservationId));
		return ResponseEntity.accepted().build();
	}
}
