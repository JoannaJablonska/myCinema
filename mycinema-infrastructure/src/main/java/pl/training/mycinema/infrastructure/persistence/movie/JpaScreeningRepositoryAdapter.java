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

	//50e8f62b-2a75-45ec-9e55-47a6ac4c3c3f
	//05ce7267-c489-468f-b6f8-68fd3efd7a6e
	@Override
	public Optional<Screening> findByMovieAndTime(final Movie movie, final LocalDateTime time) {
		return screeningRepository.findByTimeAndMovieName(time, movie.getName())
				.map(screeningEntityMapper::toScreening);
	}
}
