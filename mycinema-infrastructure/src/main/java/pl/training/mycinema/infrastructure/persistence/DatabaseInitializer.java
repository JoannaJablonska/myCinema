package pl.training.mycinema.infrastructure.persistence;

import static java.util.Arrays.asList;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
import pl.training.mycinema.infrastructure.persistence.movie.ScreeningEntity;
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
		final Movie bladeRunner = Movie.builder()
				.name("Blade Runner")
				.duration(Duration.ofHours(1).plusMinutes(30).plusSeconds(30))
				.build();

		final Movie oppenheimer = Movie.builder()
				.name("Oppenheimer")
				.duration(Duration.ofHours(3))
				.build();

		final var movies = asList(bladeRunner, oppenheimer);

		final List<Seat> seatsForBladeRunner = asList(
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(1).columnNo(1).hallNo(1).build(),
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(1).columnNo(2).hallNo(1).build(),
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(1).columnNo(3).hallNo(1).build(),
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(2).columnNo(1).hallNo(1).build(),
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(2).columnNo(2).hallNo(1).build(),
				Seat.builder().id(UUID.randomUUID().toString()).rowNo(2).columnNo(3).hallNo(1).build()
		);

		final var screenings = asList(
				Screening.builder()
						.id(UUID.randomUUID().toString())
						.movie(bladeRunner)
						.time(LocalDateTime.of(2023, 7, 30, 12, 30, 0))
						.seats(seatsForBladeRunner)
						.build()
		);

		movieRepository.saveAll(movieEntityMapper.toEntities(movies));
		//		seatRepository.saveAll(seatEntityMapper.toEntities(seatsForBladeRunner));
		screeningRepository.saveAll(screeningEntityMapper.toEntities(screenings));
    }

}
