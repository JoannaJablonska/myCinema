package pl.training.mycinema.domain.reservation.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReservationLine {

	String id;

	Seat seat;

	DiscountType discountType;
}

