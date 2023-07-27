package pl.training.mycinema.infrastructure.ui.rest.reservation;

import lombok.Value;
import pl.training.mycinema.domain.reservation.model.DiscountType;

@Value
public class PresentationalReservationLines {

	PresentationalSeat seat;

	DiscountType discountType;
}
