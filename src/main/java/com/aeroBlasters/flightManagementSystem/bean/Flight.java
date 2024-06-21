package com.aeroBlasters.flightManagementSystem.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {
    @Id
    private Long flight_number;
    private String carrier_name;
    private Integer seat_capacity;
    private Long routeId;
    private String arrival;
    private String departure;
    
	public Long getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(Long flight_number) {
		this.flight_number = flight_number;
	}
	public String getCarrier_name() {
		return carrier_name;
	}
	public void setCarrier_name(String carrier_name) {
		this.carrier_name = carrier_name;
	}
	public int getSeat_capacity() {
		return seat_capacity;
	}
	public void setSeat_capacity(int seat_capacity) {
		this.seat_capacity = seat_capacity;
	}
}
