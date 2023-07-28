package pl.training.mycinema.infrastructure.persistence.movie;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.movie.model.Screening;

@Mapper(componentModel = SPRING, uses = SeatEntityMapper.class)
public interface ScreeningEntityMapper {

//	@Mapping(source = "seats.isAvailable", target = "seat.isAvailable")
	Screening toScreening(ScreeningEntity screeningEntity);

	List<ScreeningEntity> toEntities(List<Screening> screenings);
}

