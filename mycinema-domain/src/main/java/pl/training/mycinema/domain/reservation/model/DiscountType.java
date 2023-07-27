package pl.training.mycinema.domain.reservation.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum DiscountType {

	CHILD(50.0),
	SENIOR(50.0),
	NORMAL(100.0);

	private final double discountPercentage;
}
