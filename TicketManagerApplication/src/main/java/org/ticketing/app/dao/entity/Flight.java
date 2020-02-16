package org.ticketing.app.dao.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "FLIGHT")
@Getter
@Setter
public class Flight {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "FLIGHT_DATE", nullable = false)
	private Date flightDate;
	@Column(name = "TOTAL_QUOTA", nullable = false)
	private Integer totalQuota;
	@Column(name = "TICKETS_SOLD", nullable = false)
	private Integer ticketsSold;
	@Column(name = "PRICE", nullable = false)
	private Integer price;
	@Column(name = "CANCEL_FLAG", nullable = false)
	private Integer cancelFlag = 0;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "AIRPORT_ID")
	private Airport airport;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "AIRLINE_COMPANY_ID")
	private AirlineCompany airlineCompany;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "ROUTE_ID")
	private Route route;
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;
	
	public void increaseTicketsSold(int count) {
		ticketsSold = ticketsSold + count;
	}
	
	public void decreaseTicketsSold(int count) {
		ticketsSold = ticketsSold - count;
	}
	
	public void cancelFlight() {
		this.cancelFlag = 1;
	}
}