package pl.training.mycinema.domain.reservation.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Seat {

	String id;

	int rowNo;

	int columnNo;

	int hallNo;

	boolean isAvailable = true;
}
