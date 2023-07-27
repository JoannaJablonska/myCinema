package pl.training.mycinema.application.inputs.queries;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.reservation.ReservationApplicationService;
import pl.training.mycinema.domain.reservation.model.Reservation;

@RequiredArgsConstructor
public class GetReservationQueryHandler {

	private final ReservationApplicationService reservationApplicationService;

	public Optional<Reservation> handle(final GetReservationQuery getReservationQuery) {
		return reservationApplicationService.getReservationById(getReservationQuery.getId());
	}
}
