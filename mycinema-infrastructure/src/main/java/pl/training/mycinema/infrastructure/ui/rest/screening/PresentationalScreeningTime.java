package pl.training.mycinema.infrastructure.ui.rest.screening;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PresentationalScreeningTime {
	LocalDateTime time;
}
