package pl.training.mycinema.infrastructure.persistence.reservation;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.reservation.model.Reservation;

@Mapper(componentModel = SPRING)
public interface ReservationEntityMapper {

	ReservationEntity toEntity(final Reservation reservation);

	Reservation toReservation(ReservationEntity reservationEntity);
}
