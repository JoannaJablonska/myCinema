package pl.training.mycinema.infrastructure.ui.rest.movie;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.movie.model.Movie;

@Mapper(componentModel = SPRING)
public interface PresentationalMovieMapper {

	List<PresentationalMovie> toPresentational(List<Movie> movies);
}
