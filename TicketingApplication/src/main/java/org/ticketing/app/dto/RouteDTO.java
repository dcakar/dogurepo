package org.ticketing.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteDTO {
	private Long id;
	private String departure;
	private String arrival;
}