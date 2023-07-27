package pl.training.mycinema.application.screening;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;

import java.util.List;

@RequiredArgsConstructor
public class ScreeningApplicationService {
    private final ScreeningRepository screeningRepository;

    public List<Screening> getScreeningsByMovieId(String movieName) {
        return screeningRepository.findByMovie(movieName);
    }
}
