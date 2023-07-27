package pl.training.mycinema.application.inputs.queries;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.seat.SeatApplicationService;
import pl.training.mycinema.domain.reservation.model.Seat;

import java.util.List;

@RequiredArgsConstructor
public class GetSeatsQueryHandler {
    private final SeatApplicationService seatApplicationService;

    public List<Seat> handle(final GetSeatsQuery getSeatsQuery) {
        return seatApplicationService.getAvailableSeatsByScreeningId(getSeatsQuery.getId());
    }
}
