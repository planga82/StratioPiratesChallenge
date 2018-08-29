package com.challenge.pirates.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.challenge.pirates.domain.JsonResult;

@Entity
public class EventDao  extends JsonResult implements Serializable{

	private static final long serialVersionUID = -7740444078502066724L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String uUID;	
	
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
	private Long time;

	public EventDao() {
		super();
	}

	public EventDao(Long id, String uUID, String eventType, String ship, String port, Long goldCoins, Long drimBarrels,
			Long time) {
		super();
		this.id = id;
		this.uUID = uUID;
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

	public String getUUID() {
		return uUID;
	}

	public void setUUID(String uUID) {
		this.uUID = uUID;
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

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uUID == null) ? 0 : uUID.hashCode());
		result = prime * result + ((drimBarrels == null) ? 0 : drimBarrels.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((goldCoins == null) ? 0 : goldCoins.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((ship == null) ? 0 : ship.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDao other = (EventDao) obj;
		if (uUID == null) {
			if (other.uUID != null)
				return false;
		} else if (!uUID.equals(other.uUID))
			return false;
		if (drimBarrels == null) {
			if (other.drimBarrels != null)
				return false;
		} else if (!drimBarrels.equals(other.drimBarrels))
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (goldCoins == null) {
			if (other.goldCoins != null)
				return false;
		} else if (!goldCoins.equals(other.goldCoins))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (ship == null) {
			if (other.ship != null)
				return false;
		} else if (!ship.equals(other.ship))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EventDao [id=" + id + ", UUID=" + uUID + ", eventType=" + eventType + ", ship=" + ship + ", port="
				+ port + ", goldCoins=" + goldCoins + ", drimBarrels=" + drimBarrels + ", time=" + time + "]";
	}

	
	
	
}
