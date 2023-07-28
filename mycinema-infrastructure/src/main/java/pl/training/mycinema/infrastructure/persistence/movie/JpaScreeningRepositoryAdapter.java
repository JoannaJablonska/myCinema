package pl.training.mycinema.infrastructure.persistence.movie;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;
import pl.training.mycinema.domain.reservation.model.Seat;

@Primary
@Transactional
@Repository
@RequiredArgsConstructor
public class JpaScreeningRepositoryAdapter implements ScreeningRepository {

    private final JpaScreeningRepository screeningRepository;

    private final ScreeningEntityMapper screeningEntityMapper;
    private final SeatEntityMapper seatEntityMapper;

    @Override
    public Optional<Screening> findByMovieAndTime(final Movie movie, final LocalDateTime time) {
        return screeningRepository.findByTimeAndMovieName(time, movie.getName())
                .map(screeningEntityMapper::toScreening);
    }

    @Override
    public List<Screening> findByMovie(String movieName) {
        return screeningRepository.findByMovieName(movieName)
                .stream()
                .map(screeningEntityMapper::toScreening)
                .collect(Collectors.toList());
    }

    @Override
    public List<Seat> findAvailableSeatsByScreeningId(String id) {
        Optional<ScreeningEntity> screening = screeningRepository.findById(id);
        if (screening.isPresent()) {
            List<SeatEntity> seatEntities = screening.stream().findAny().stream().map(ScreeningEntity::getSeats).flatMap(Collection::stream).toList();
            return seatEntities.stream().filter(SeatEntity::isAvailable).map(seatEntityMapper::toSeat).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }
}
