package pl.training.mycinema.domain.reservation.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReservationLines {

	String id;

	Seat seat;

	DiscountType discountType = DiscountType.NORMAL;
}

