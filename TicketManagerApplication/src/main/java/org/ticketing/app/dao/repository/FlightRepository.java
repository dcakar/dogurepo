package org.ticketing.app.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.ticketing.app.dao.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>, JpaSpecificationExecutor<Flight> {
	final String FIND_BY_PARAMS = "select f from Flight f join f.airport ap join f.airlineCompany ac join f.route r"
			+ " where r.departure = :departure and r.arrival = :arrival and ap.id = :airportId and ac.id = :airlineCompanyId and f.flightDate >= :flightStartDate and f.flightDate <= :flightEndDate"
			+ " and f.ticketsSold < f.totalQuota";

	@Query(value = FIND_BY_PARAMS)
	List<Flight> findByParams(@Param("departure") String departure, @Param("arrival") String arrival,
			@Param("airlineCompanyId") Long airlineCompanyId, @Param("airportId") Long airportId,
			@Param("flightStartDate") Date flightStartDate, @Param("flightEndDate") Date flightEndDate);

}
