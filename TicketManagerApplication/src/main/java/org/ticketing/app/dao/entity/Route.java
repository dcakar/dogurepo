package org.ticketing.app.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ROUTE")
@Getter
@Setter
public class Route {
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "DEPARTURE", nullable = false)
	private String departure;
	@Column(name = "ARRIVAL", nullable = false)
	private String arrival;
	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Flight> flightList;
}