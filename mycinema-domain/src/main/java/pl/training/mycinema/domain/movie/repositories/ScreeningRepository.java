package pl.training.mycinema.domain.movie.repositories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.reservation.model.Seat;

public interface ScreeningRepository {

	Optional<Screening> findByMovieAndTime(final Movie movie, final LocalDateTime time);
	List<Screening> findByMovie(final String movieName);
    List<Seat> findAvailableSeatsByScreeningId(String id);
}
