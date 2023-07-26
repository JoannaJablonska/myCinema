package pl.training.mycinema.application.inputs.commands;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import pl.training.mycinema.domain.reservation.model.ReservationLines;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReserveSeatsCommand {

	String movieName;

	LocalDateTime time;

	List<ReservationLines> reservationLines;
}