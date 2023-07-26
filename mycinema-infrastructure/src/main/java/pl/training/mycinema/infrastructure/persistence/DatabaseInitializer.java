package pl.training.mycinema.infrastructure.persistence;

import static java.util.Arrays.asList;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.reservation.model.Seat;
import pl.training.mycinema.infrastructure.persistence.movie.JpaMovieRepository;
import pl.training.mycinema.infrastructure.persistence.movie.JpaScreeningRepository;
import pl.training.mycinema.infrastructure.persistence.movie.JpaSeatRepository;
import pl.training.mycinema.infrastructure.persistence.movie.MovieEntityMapper;
import pl.training.mycinema.infrastructure.persistence.movie.ScreeningEntityMapper;

@Transactional
@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements ApplicationRunner {

    private final JpaMovieRepository movieRepository;

	private final MovieEntityMapper movieEntityMapper;

	private final JpaScreeningRepository screeningRepository;

	private final ScreeningEntityMapper screeningEntityMapper;

	private final JpaSeatRepository seatRepository;

	private final SeatEntityMapper seatEntityMapper;

	@Override
    public void run(ApplicationArguments args) {
		final Movie bladeRunner = new Movie("Blade Runner", Duration.ofHours(1).plusMinutes(30).plusSeconds(30));
		final Movie oppenheimer = new Movie("Oppenheimer", Duration.ofHours(3));
		final var movies = asList(bladeRunner, oppenheimer);

		final List<Seat> seatsForBladeRunner = asList(
				new Seat(1, 1, 1),
				new Seat(1, 2, 1),
				new Seat(1, 3, 1),
				new Seat(2, 1, 1),
				new Seat(2, 2, 1),
				new Seat(2, 3, 1)
		);

		final var screenings = asList(
				new Screening(
						bladeRunner,
						LocalDateTime.of(2023, 7, 30, 12, 30, 0),
						seatsForBladeRunner
				)
		);

		movieRepository.saveAll(movieEntityMapper.toEntities(movies));
		seatRepository.saveAll(seatEntityMapper.toEntities(seatsForBladeRunner));
		screeningRepository.saveAll(screeningEntityMapper.toEntities(screenings));
    }

}
