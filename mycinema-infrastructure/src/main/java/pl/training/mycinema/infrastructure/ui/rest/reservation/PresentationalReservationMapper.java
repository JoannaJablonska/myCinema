package pl.training.mycinema.infrastructure.ui.rest.reservation;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.reservation.model.Reservation;

@Mapper(componentModel = SPRING)
public interface PresentationalReservationMapper {

	PresentationalReservation toPresentational(Reservation reservations);
}
