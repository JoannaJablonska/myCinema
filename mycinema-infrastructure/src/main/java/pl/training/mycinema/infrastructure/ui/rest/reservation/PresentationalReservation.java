package pl.training.mycinema.infrastructure.ui.rest.reservation;

import java.util.List;

import lombok.Value;

@Value
public class PresentationalReservation {

	PresentationalScreening screening;

	List<PresentationalReservationLines> reservationLines;
}
