package pl.training.mycinema.infrastructure.persistence.reservation;

import org.springframework.data.repository.CrudRepository;

public interface JpaReservationRepository extends CrudRepository<ReservationEntity, String> {

}
