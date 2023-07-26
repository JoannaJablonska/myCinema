package pl.training.mycinema.domain.reservation.model;

import lombok.Value;

@Value
public class Seat {

	int row;

	int column;

	int hallNo;

	boolean isAvailable = true;
}
