package pl.training.mycinema.infrastructure.persistence.movie;

import org.springframework.data.repository.CrudRepository;

public interface JpaSeatRepository extends CrudRepository<SeatEntity, String> {

}
