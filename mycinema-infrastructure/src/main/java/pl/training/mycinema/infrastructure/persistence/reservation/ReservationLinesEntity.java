package pl.training.mycinema.infrastructure.persistence.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import pl.training.mycinema.domain.reservation.model.DiscountType;
import pl.training.mycinema.infrastructure.persistence.movie.SeatEntity;

@Entity(name = "ReservationLine")
@Getter
@Setter
public class ReservationLinesEntity {

	@Id
	String id;

	@OneToOne
	SeatEntity seat;

	DiscountType discountType;
}
