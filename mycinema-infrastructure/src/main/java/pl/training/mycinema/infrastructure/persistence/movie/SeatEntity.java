package pl.training.mycinema.infrastructure.persistence.movie;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name = "Seat")
@Getter
@Setter
public class SeatEntity {

	@Id
	String id = UUID.randomUUID().toString();

	int rowNo;

	int columnNo;

	int hallNo;

	boolean isAvailable;

	@ManyToOne(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "screeningId")
	ScreeningEntity screening;
}
