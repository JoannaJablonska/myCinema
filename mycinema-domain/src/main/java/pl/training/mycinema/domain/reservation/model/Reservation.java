package pl.training.mycinema.domain.reservation.model;

import java.util.List;
import java.util.UUID;

import lombok.Value;
import pl.training.mycinema.domain.movie.model.Screening;

@Value
public class Reservation {

	String id = UUID.randomUUID().toString();

	Screening screening;

	List<ReservationLines> reservationLines;

	boolean isPaid = false;
}
