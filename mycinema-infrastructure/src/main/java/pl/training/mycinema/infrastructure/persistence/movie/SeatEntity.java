package pl.training.mycinema.infrastructure.persistence.movie;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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
}
