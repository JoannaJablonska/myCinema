package pl.training.mycinema.infrastructure.ui.rest.reservation;

import lombok.Value;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.reservation.model.ReservationLines;

import java.util.List;

@Value
public class PresentationalReservation {

	Screening screening;

	List<ReservationLines> reservationLines;
}
