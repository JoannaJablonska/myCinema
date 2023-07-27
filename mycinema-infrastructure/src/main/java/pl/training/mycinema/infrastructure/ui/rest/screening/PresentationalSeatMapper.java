package pl.training.mycinema.infrastructure.ui.rest.screening;

import org.mapstruct.Mapper;
import pl.training.mycinema.domain.reservation.model.Seat;
import pl.training.mycinema.infrastructure.ui.rest.reservation.PresentationalSeat;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PresentationalSeatMapper {
	List<PresentationalSeat> toPresentational(List<Seat> seats);
}
