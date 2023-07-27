package pl.training.mycinema.domain.reservation.repositories;

import java.util.Optional;

import pl.training.mycinema.domain.reservation.model.Reservation;

public interface ReservationRepository {

	void save(final Reservation reservation);

	Optional<Reservation> getById(String id);
}
