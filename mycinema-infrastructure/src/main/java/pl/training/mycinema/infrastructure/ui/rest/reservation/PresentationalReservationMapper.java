package pl.training.mycinema.infrastructure.ui.rest.reservation;

import org.mapstruct.Mapper;
import pl.training.mycinema.domain.reservation.model.Reservation;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PresentationalReservationMapper {

	PresentationalReservation toPresentational(Reservation reservations);
}
