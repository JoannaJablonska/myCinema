package pl.training.mycinema.infrastructure.persistence.reservation;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pl.training.mycinema.domain.reservation.model.Reservation;
import pl.training.mycinema.domain.reservation.repositories.ReservationRepository;

@Primary
@Transactional
@Repository
@RequiredArgsConstructor
public class JpaReservationRepositoryAdapter implements ReservationRepository {

	private final JpaReservationRepository reservationRepository;

	private final ReservationEntityMapper mapper;

	@Override
	public void save(final Reservation reservation) {
		final ReservationEntity entity = mapper.toEntity(reservation);
		reservationRepository.save(entity);
	}

	@Override
	public Optional<Reservation> getById(final String id) {
		return reservationRepository.findById(id)
				.map(mapper::toReservation);
	}
}
