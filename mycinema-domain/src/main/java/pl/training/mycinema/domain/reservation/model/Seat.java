package pl.training.mycinema.domain.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
public class Seat {

	private String id;

	private int rowNo;

	private int columnNo;

	private int hallNo;

//	@Setter
	private boolean isAvailable;
}
