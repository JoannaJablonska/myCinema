package pl.training.mycinema.infrastructure.ui.rest.movie;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PresentationalMovie {

	String name;

	String duration;
}
