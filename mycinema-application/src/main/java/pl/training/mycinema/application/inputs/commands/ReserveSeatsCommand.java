package pl.training.mycinema.application.inputs.commands;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.training.mycinema.domain.reservation.model.ReservationLine;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReserveSeatsCommand {

	String movieName;

	LocalDateTime time;

	List<ReservationLine> reservationLines;
}
