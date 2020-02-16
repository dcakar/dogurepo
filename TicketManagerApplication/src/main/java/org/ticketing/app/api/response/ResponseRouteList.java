package org.ticketing.app.api.response;

import java.util.List;

import org.ticketing.app.dto.RouteDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRouteList {
	private List<RouteDTO> routeDtoList;

}
