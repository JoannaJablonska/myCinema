package pl.training.mycinema.domain.movie.model;

import java.time.Duration;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Movie {

	String name;

	Duration duration;
}
