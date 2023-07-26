package pl.training.mycinema.domain.reservation.model;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class Seat {

	int rowNo;

	int columnNo;

	public Seat(int rowNo, int columnNo, int hallNo) {
		this.rowNo = rowNo;
		this.columnNo = columnNo;
		this.hallNo = hallNo;
	}

	int hallNo;

	boolean isAvailable = true;
}
