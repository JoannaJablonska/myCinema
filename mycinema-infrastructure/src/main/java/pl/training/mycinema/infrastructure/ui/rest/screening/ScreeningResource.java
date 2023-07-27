package pl.training.mycinema.infrastructure.ui.rest.screening;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.mycinema.application.inputs.queries.GetScreeningsQuery;
import pl.training.mycinema.application.inputs.queries.GetScreeningsQueryHandler;
import pl.training.mycinema.application.inputs.queries.GetSeatsQuery;
import pl.training.mycinema.application.inputs.queries.GetSeatsQueryHandler;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.reservation.model.Seat;
import pl.training.mycinema.infrastructure.ui.rest.reservation.PresentationalSeat;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@RequiredArgsConstructor
public class ScreeningResource {
    private final GetScreeningsQueryHandler getScreeningsQueryHandler;

    private final PresentationalScreeningMapper presentationalScreeningMapper;
    private final GetSeatsQueryHandler getSeatsQueryHandler;
    private final PresentationalSeatMapper presentationalSeatMapper;

    @GetMapping("/{movieName}")
    public ResponseEntity<List<PresentationalScreeningTime>> getScreenings(@PathVariable String movieName) {
        final List<Screening> queryResults = getScreeningsQueryHandler.handle(new GetScreeningsQuery(movieName));
        return queryResults.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(presentationalScreeningMapper.toPresentational(queryResults));
    }

    @GetMapping("/{idScreening}/availableSeats")
    public ResponseEntity<List<PresentationalSeat>> getSeats(@PathVariable String idScreening) {
        final List<Seat> queryResults = getSeatsQueryHandler.handle(new GetSeatsQuery(idScreening));
        return queryResults.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(presentationalSeatMapper.toPresentational(queryResults));
    }
}
