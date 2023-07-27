package pl.training.mycinema.infrastructure.persistence.movie;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Screening")
@Getter
@Setter
public class ScreeningEntity {

	@Id
	String id;

	@ManyToOne(cascade=CascadeType.ALL)
	MovieEntity movie;

	LocalDateTime time;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<SeatEntity> seats;
}
