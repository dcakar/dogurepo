package com.ozan.forex.application.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.ozan.forex.application.dao.entity.ConversionsLog;

public interface ConversionsLogRepository extends JpaRepository<ConversionsLog, Long>, JpaSpecificationExecutor<ConversionsLog> {
}
