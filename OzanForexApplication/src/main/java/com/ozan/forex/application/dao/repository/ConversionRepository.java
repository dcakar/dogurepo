package com.ozan.forex.application.dao.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ozan.forex.application.dao.entity.Conversion;

@Repository
public interface ConversionRepository extends JpaRepository<Conversion, Long>, JpaSpecificationExecutor<Conversion> {
	@Query("select c from Conversion c where c.transactionId = :transactionId or c.transactionDate = :transactionDate")
	List<Conversion> findByTransactionIdOrTransactionDate(@Param("transactionId") String transactionId,
			                                                  @Param("transactionDate") LocalDateTime transactionDate);
}
