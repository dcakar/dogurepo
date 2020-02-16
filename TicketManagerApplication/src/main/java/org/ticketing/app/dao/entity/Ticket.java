package org.ticketing.app.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TICKET")
@Getter
@Setter
public class Ticket {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "FLIGHT_ID")
	private Flight flight;
	@Column(name = "TICKET_NUMBER", nullable = false)
	private String ticketNumber;
	@Column(name = "TICKET_CLASS", nullable = false)
	private String ticketClass;
	@Column(name = "CANCEL_FLAG", nullable = false)
	private Integer cancelFlag;
	
}
