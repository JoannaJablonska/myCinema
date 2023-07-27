package pl.training.mycinema.infrastructure.persistence.reservation;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import pl.training.mycinema.infrastructure.persistence.movie.ScreeningEntity;

@Entity(name = "Reservation")
@Getter
@Setter
public class ReservationEntity {

	@Id
	String id;

	@ManyToOne
	ScreeningEntity screening;

	@OneToMany(cascade = CascadeType.ALL)
	List<ReservationLinesEntity> reservationLines;

	boolean isPaid = false;
}
