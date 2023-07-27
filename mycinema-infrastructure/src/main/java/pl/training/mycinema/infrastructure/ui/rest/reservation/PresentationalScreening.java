package pl.training.mycinema.infrastructure.ui.rest.reservation;

import java.time.LocalDateTime;

import lombok.Value;
import pl.training.mycinema.infrastructure.ui.rest.movie.PresentationalMovie;

@Value
public class PresentationalScreening {

	PresentationalMovie movie;

	LocalDateTime time;
}
