package pl.training.mycinema.infrastructure.ui.rest.screening;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.mycinema.application.inputs.queries.GetScreeningsQuery;
import pl.training.mycinema.application.inputs.queries.GetScreeningsQueryHandler;
import pl.training.mycinema.domain.movie.model.Screening;

import java.util.List;

@RestController
@RequestMapping("/screenings")
@RequiredArgsConstructor
public class ScreeningResource {
    private final GetScreeningsQueryHandler getScreeningsQueryHandler;

    private final PresentationalScreeningMapper presentationalScreeningMapper;

    @GetMapping("/{movieName}")
    public ResponseEntity<List<PresentationalScreeningTime>> getScreenings(@PathVariable String movieName) {
        final List<Screening> queryResults = getScreeningsQueryHandler.handle(new GetScreeningsQuery(movieName));
        return queryResults.isEmpty() ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(presentationalScreeningMapper.toPresentational(queryResults));
    }
}
