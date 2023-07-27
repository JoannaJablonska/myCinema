package pl.training.mycinema.infrastructure.ui.rest.reservation;

import lombok.Value;

@Value
public class PresentationalSeat {

	int rowNo;

	int columnNo;

	int hallNo;
}
