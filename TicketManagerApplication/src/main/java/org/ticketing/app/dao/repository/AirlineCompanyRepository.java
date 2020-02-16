package org.ticketing.app.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.ticketing.app.dao.entity.AirlineCompany;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long>, JpaSpecificationExecutor<AirlineCompany> {
}
