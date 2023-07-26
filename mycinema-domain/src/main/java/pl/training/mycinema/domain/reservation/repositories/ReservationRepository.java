package pl.training.mycinema.domain.reservation.repositories;

import pl.training.mycinema.domain.reservation.model.Reservation;

public interface ReservationRepository {

	void save(final Reservation reservation);
}
