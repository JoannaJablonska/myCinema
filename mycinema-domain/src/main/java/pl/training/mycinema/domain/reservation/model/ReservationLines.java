package pl.training.mycinema.domain.reservation.model;

import lombok.Value;

@Value
public class ReservationLines {

	Seat seat;

	DiscountType discountType;
}
