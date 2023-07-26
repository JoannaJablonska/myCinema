package pl.training.mycinema.domain.reservation.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationLines {

	Seat seat;

	DiscountType discountType = DiscountType.NORMAL;
}
