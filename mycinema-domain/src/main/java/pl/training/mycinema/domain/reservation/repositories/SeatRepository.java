package pl.training.mycinema.domain.reservation.repositories;

import java.util.List;

import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.reservation.model.Seat;

public interface SeatRepository {

	List<Seat> findSeatsByScreening(final Screening screening);
}
