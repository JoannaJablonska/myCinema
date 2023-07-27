package pl.training.mycinema.infrastructure.ui.rest.reservation;

import lombok.Value;
import pl.training.mycinema.domain.reservation.model.DiscountType;
import pl.training.mycinema.domain.reservation.model.Seat;

@Value
public class PresentationalReservationLines {

	Seat seat;

	DiscountType discountType;
}
