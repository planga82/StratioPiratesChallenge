package com.challenge.pirates.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EventReplicaDao implements Serializable{

	private static final long serialVersionUID = -7740444078502066724L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String UUID;	
	
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
	
	@Column
	private String hostPort;

	public EventReplicaDao() {
		super();
	}

	public EventReplicaDao(String uUID, String eventType, String ship, String port, Long goldCoins,
			Long drimBarrels, String time, String hostPort) {
		super();
		this.id = null;
		UUID = uUID;
		this.eventType = eventType;
		this.ship = ship;
		this.port = port;
		this.goldCoins = goldCoins;
		this.drimBarrels = drimBarrels;
		this.time = time;
		this.hostPort = hostPort;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
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

	public String getHostPort() {
		return hostPort;
	}

	public void setHostPort(String hostPort) {
		this.hostPort = hostPort;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UUID == null) ? 0 : UUID.hashCode());
		result = prime * result + ((drimBarrels == null) ? 0 : drimBarrels.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((goldCoins == null) ? 0 : goldCoins.hashCode());
		result = prime * result + ((hostPort == null) ? 0 : hostPort.hashCode());
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
		EventReplicaDao other = (EventReplicaDao) obj;
		if (UUID == null) {
			if (other.UUID != null)
				return false;
		} else if (!UUID.equals(other.UUID))
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
		if (hostPort == null) {
			if (other.hostPort != null)
				return false;
		} else if (!hostPort.equals(other.hostPort))
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
		return "EventReplicaDao [id=" + id + ", UUID=" + UUID + ", eventType=" + eventType + ", ship=" + ship
				+ ", port=" + port + ", goldCoins=" + goldCoins + ", drimBarrels=" + drimBarrels + ", time=" + time
				+ ", hostPort=" + hostPort + "]";
	}
	
}
