package pl.training.mycinema.infrastructure.ui.rest.reservation;

import java.util.List;

import lombok.Value;

@Value
public class PresentationalReservation {

	String id;

	PresentationalScreening screening;

	List<PresentationalReservationLines> reservationLines;

	boolean paid;

	double totalPrice;

	boolean active;
}
