package pl.training.mycinema.domain.movie.model;

import java.time.Duration;

import lombok.Value;

@Value
public class Movie {

	String name;

	Duration duration;
}