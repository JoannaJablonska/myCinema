package pl.training.mycinema.application.seat;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;
import pl.training.mycinema.domain.reservation.model.Seat;

import java.util.List;

@RequiredArgsConstructor
public class SeatApplicationService {
    private final ScreeningRepository screeningRepository;

    public List<Seat> getAvailableSeatsById(String id) {
        return screeningRepository.findAvailableSeatsByScreeningId(id);
    }
}
