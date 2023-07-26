package pl.training.mycinema.infrastructure.persistence.movie;

import java.time.Duration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Movie")
@Getter
@Setter
public class MovieEntity {

	@Id
	private String name;

	private Duration duration;
}
