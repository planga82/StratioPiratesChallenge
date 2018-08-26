package com.challenge.pirates.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventDao implements Serializable{

	private static final long serialVersionUID = -7740444078502066724L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String eventType;
	
	@Column
	private String ship;
	
	@Column
	private String  port;
	
	@Column
	private Long goldCoins;
	
	@Column
	private Long drimBarrels;
	
	@Column
	private String time;

	public EventDao() {
		super();
	}

	public EventDao(Long id, String eventType, String ship, String port, Long goldCoins, Long drimBarrels,
			String time) {
		super();
		this.id = id;
		this.eventType = eventType;
		this.ship = ship;
		this.port = port;
		this.goldCoins = goldCoins;
		this.drimBarrels = drimBarrels;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getShip() {
		return ship;
	}

	public void setShip(String ship) {
		this.ship = ship;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Long getGoldCoins() {
		return goldCoins;
	}

	public void setGoldCoins(Long goldCoins) {
		this.goldCoins = goldCoins;
	}

	public Long getDrimBarrels() {
		return drimBarrels;
	}

	public void setDrimBarrels(Long drimBarrels) {
		this.drimBarrels = drimBarrels;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
	
	
	
}
