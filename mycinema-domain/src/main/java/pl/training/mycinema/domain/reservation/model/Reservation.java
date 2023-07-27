package pl.training.mycinema.domain.reservation.model;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import pl.training.mycinema.domain.movie.model.Screening;

@Value
@Builder
public class Reservation {

	String id;

	Screening screening;

	List<ReservationLine> reservationLines;

	boolean isPaid = false;
}
