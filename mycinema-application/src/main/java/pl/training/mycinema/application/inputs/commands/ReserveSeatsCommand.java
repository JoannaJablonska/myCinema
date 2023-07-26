package pl.training.mycinema.application.inputs.commands;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Value;
import pl.training.mycinema.domain.reservation.model.ReservationLines;

@Value
public class ReserveSeatsCommand {

	String movieName;

	LocalDateTime time;

	List<ReservationLines> reservationLines;
}
