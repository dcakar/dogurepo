package com.ozan.forex.application.dao.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CONVERSION")
@Getter
@Setter
public class Conversion {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "SOURCE_AMOUNT")
	private BigDecimal sourceAmount;
	@Column(name = "SOURCE_CURRENCY", length = 3)
	private String sourceCurrency;
	@Column(name = "TARGET_CURRENCY", length = 3)
	private String targetCurrency;
	@Column(name = "CONVERSION_AMOUNT")
	private BigDecimal conversionAmount;
	@Column(name = "TRANSACTION_ID", length = 50)
	private String transactionId;
	@Column(name = "TRANSACTION_DATE")
	private LocalDateTime transactionDate;
}
