package pl.training.mycinema.infrastructure.persistence.movie;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.movie.model.Movie;
import pl.training.mycinema.domain.movie.model.Screening;
import pl.training.mycinema.domain.movie.repositories.ScreeningRepository;

@Primary
@Transactional
@Repository
@RequiredArgsConstructor
public class JpaScreeningRepositoryAdapter implements ScreeningRepository {

	private final JpaScreeningRepository screeningRepository;

	private final ScreeningEntityMapper screeningEntityMapper;

	private final MovieEntityMapper movieEntityMapper;

	@Override
	public Optional<Screening> findByMovieAndTime(final Movie movie, final LocalDateTime time) {
		final MovieEntity movieEntity = movieEntityMapper.toEntity(movie);
		return screeningRepository.findByMovieAndTime(movieEntity, time)
				.map(screeningEntityMapper::toScreening);
	}
}
