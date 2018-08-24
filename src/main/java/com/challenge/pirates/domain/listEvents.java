package com.challenge.pirates.domain;

import java.util.List;

public class listEvents extends JsonResult{

	private List<Event> events;

	public listEvents() {
		super();
	}

	public listEvents(List<Event> events) {
		super();
		this.events = events;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((events == null) ? 0 : events.hashCode());
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
		listEvents other = (listEvents) obj;
		if (events == null) {
			if (other.events != null)
				return false;
		} else if (!events.equals(other.events))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "listEvents [events=" + events + "]";
	}
	
	
	
	
}
