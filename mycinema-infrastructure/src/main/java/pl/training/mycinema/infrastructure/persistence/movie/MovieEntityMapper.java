package pl.training.mycinema.infrastructure.persistence.movie;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import java.util.List;

import org.mapstruct.Mapper;

import pl.training.mycinema.domain.movie.model.Movie;

@Mapper(componentModel = SPRING)
public interface MovieEntityMapper {

	List<Movie> toMultipleMovies(Iterable<MovieEntity> movies);

	Movie toMovie(MovieEntity movie);

	List<MovieEntity> toEntities(List<Movie> movies);
	MovieEntity toEntity(Movie movie);
}
