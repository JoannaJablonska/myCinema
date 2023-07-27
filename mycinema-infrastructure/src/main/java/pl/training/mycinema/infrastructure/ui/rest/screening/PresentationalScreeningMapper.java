package pl.training.mycinema.infrastructure.ui.rest.screening;

import org.mapstruct.Mapper;
import pl.training.mycinema.domain.movie.model.Screening;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PresentationalScreeningMapper {
	List<PresentationalScreeningTime> toPresentational(List<Screening> screenings);
}
