package pl.training.mycinema.infrastructure.ui.rest.reservation;

import java.util.List;

import lombok.Value;
import pl.training.mycinema.domain.movie.model.Screening;

@Value
public class PresentationalReservation {

	Screening screening;

	List<PresentationalReservationLines> reservationLines;
}
