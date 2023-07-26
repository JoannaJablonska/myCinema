package pl.training.mycinema.infrastructure.ui.rest.movie;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.movie.Movie;

@Mapper(componentModel = SPRING)
public interface PresentationalMovieMapper {

//TODO	@Mapping(target = "duration", expression = "java(org.apache.commons.lang3.time.DurationFormatUtils.formatDuration(duration, \"**H:mm:ss**\", true))")
	List<PresentationalMovie> toPresentational(List<Movie> movies);
}
