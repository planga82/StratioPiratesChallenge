package com.challenge.pirates.service;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.pirates.dao.EventsRepository;
import com.challenge.pirates.domain.Event;
import com.challenge.pirates.domain.ListEvents;
import com.challenge.pirates.entities.EventDao;
import com.challenge.pirates.util.GeneralConstants;




@Service
public class ClientService {

	@Autowired
	EventsRepository repository;
	
	public boolean existShip(String shipId) {
		return repository.existsByShip(shipId);
	}
	
	public boolean existPort(String portId) {
		return repository.existsByPort(portId);
	}
	
	public ListEvents getListEventsByShip(String ship, String eventType){
		
		List<EventDao> list = null;
		if(eventType.equals(GeneralConstants.EVENT_ALL)) {
			list = getAllEventsByShip(ship);
		}else if(eventType.equals(GeneralConstants.EVENT_ARRIVAL)) {
			
		}else if(eventType.equals(GeneralConstants.EVENT_DEPARTURE)) {
			
		}
		
		return new ListEvents(eventDaoToEvent(list));
	}
	
	public ListEvents getListEventsByPort(String port, String eventType){
		
		List<EventDao> list = null;
		if(eventType.equals(GeneralConstants.EVENT_ALL)) {
			list = getAllEventsByPort(port);
		}else if(eventType.equals(GeneralConstants.EVENT_ARRIVAL)) {
			
		}else if(eventType.equals(GeneralConstants.EVENT_DEPARTURE)) {
			
		}
		
		return new ListEvents(eventDaoToEvent(list));
	}
	
	private List<EventDao> getAllEventsByShip(String ship){
		return repository.findAllByShip(ship);
	}
	
	private List<EventDao> getAllEventsByPort(String port){
		return repository.findAllByPort(port);
	}
	
	private List<Event> eventDaoToEvent(List<EventDao> list) {
		List<Event> ret = new ArrayList<Event>();
		for (Iterator<EventDao> iterator = list.iterator(); iterator.hasNext();) {
			EventDao eventDao = iterator.next();
			ret.add(new Event(eventDao.getTime(), eventDao.getEventType(), eventDao.getPort(), eventDao.getShip(), eventDao.getGoldCoins(), eventDao.getDrimBarrels()));
		}
		return ret;
	}
	
	
}
