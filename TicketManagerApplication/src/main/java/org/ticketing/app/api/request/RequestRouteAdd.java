package org.ticketing.app.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestRouteAdd {
	private String departure;
	private String arrival;
}
