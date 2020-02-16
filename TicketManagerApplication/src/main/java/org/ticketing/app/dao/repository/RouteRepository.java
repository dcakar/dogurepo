package org.ticketing.app.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.ticketing.app.dao.entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {
}
