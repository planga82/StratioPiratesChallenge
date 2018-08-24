package com.challenge.pirates.domain;

public class Event{

	private String timeStamp;
	private String eventType;
	private String portId;
	private Long goldCoins;
	private Long drumBarrels;
	
	public Event() {
		super();
	}

	public Event(String timeStamp, String eventType, String portId, Long goldCoins, Long drumBarrels) {
		super();
		this.timeStamp = timeStamp;
		this.eventType = eventType;
		this.portId = portId;
		this.goldCoins = goldCoins;
		this.drumBarrels = drumBarrels;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getPortId() {
		return portId;
	}

	public void setPortId(String portId) {
		this.portId = portId;
	}

	public Long getGoldCoins() {
		return goldCoins;
	}

	public void setGoldCoins(Long goldCoins) {
		this.goldCoins = goldCoins;
	}

	public Long getDrumBarrels() {
		return drumBarrels;
	}

	public void setDrumBarrels(Long drumBarrels) {
		this.drumBarrels = drumBarrels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drumBarrels == null) ? 0 : drumBarrels.hashCode());
		result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((goldCoins == null) ? 0 : goldCoins.hashCode());
		result = prime * result + ((portId == null) ? 0 : portId.hashCode());
		result = prime * result + ((timeStamp == null) ? 0 : timeStamp.hashCode());
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
		Event other = (Event) obj;
		if (drumBarrels == null) {
			if (other.drumBarrels != null)
				return false;
		} else if (!drumBarrels.equals(other.drumBarrels))
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
		if (portId == null) {
			if (other.portId != null)
				return false;
		} else if (!portId.equals(other.portId))
			return false;
		if (timeStamp == null) {
			if (other.timeStamp != null)
				return false;
		} else if (!timeStamp.equals(other.timeStamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [timeStamp=" + timeStamp + ", eventType=" + eventType + ", portId=" + portId + ", goldCoins="
				+ goldCoins + ", drumBarrels=" + drumBarrels + "]";
	}
	
	
	
	
	
	
}
