package pl.training.mycinema.infrastructure.persistence;

import static java.util.Arrays.asList;

import java.time.Duration;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.Movie;
import pl.training.mycinema.infrastructure.persistence.movie.JpaMovieRepository;
import pl.training.mycinema.infrastructure.persistence.movie.MovieEntityMapper;

@Transactional
@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements ApplicationRunner {

    private final JpaMovieRepository movieRepository;

	private final MovieEntityMapper movieEntityMapper;

    @Override
    public void run(ApplicationArguments args) {
		final var movies = asList(
				new Movie("Blade Runner", Duration.ofHours(1).plusMinutes(30).plusSeconds(30)),
				new Movie("Oppenheimer", Duration.ofHours(3))
		);
		movieRepository.saveAll(movieEntityMapper.toEntities(movies));
    }

}
