package pl.training.mycinema.application.inputs.queries;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.application.screening.ScreeningApplicationService;
import pl.training.mycinema.domain.movie.model.Screening;

import java.util.List;

@RequiredArgsConstructor
public class GetScreeningsQueryHandler {
    private final ScreeningApplicationService screeningApplicationService;

    public List<Screening> handle(final GetScreeningsQuery getScreeningsQuery) {
        return screeningApplicationService.getScreeningsByMovieId(getScreeningsQuery.getMovieName());
    }
}
