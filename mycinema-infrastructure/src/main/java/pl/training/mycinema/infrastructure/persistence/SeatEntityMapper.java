package pl.training.mycinema.infrastructure.persistence;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.reservation.model.Seat;
import pl.training.mycinema.infrastructure.persistence.movie.SeatEntity;

@Mapper(componentModel = SPRING)
public interface SeatEntityMapper {

	List<SeatEntity> toEntities(final List<Seat> seats);
}
