package com.challenge.pirates.service;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.pirates.dao.EventsRepository;
import com.challenge.pirates.domain.Event;
import com.challenge.pirates.domain.ListEvents;
import com.challenge.pirates.domain.Stock;
import com.challenge.pirates.entities.EventDao;
import com.challenge.pirates.util.GeneralConstants;




@Service
public class ClientService {

	@Autowired
	EventsRepository eventRepository;
	
	public boolean existShip(String shipId) {
		return eventRepository.existsByShip(shipId);
	}
	
	public boolean existPort(String portId) {
		return eventRepository.existsByPort(portId);
	}
	
	public ListEvents getListEventsByShip(String ship, String eventType){
		
		List<EventDao> list = null;
		if(eventType.equals(GeneralConstants.EVENT_ALL)) {
			list = getAllEventsByShip(ship);
		}else{
			list = getAllEventsByShipEventType(ship, eventType);
		}
		
		return new ListEvents(eventDaoToEvent(list));
	}
	
	public ListEvents getListEventsByPort(String port, String eventType){
		
		List<EventDao> list = null;
		if(eventType.equals(GeneralConstants.EVENT_ALL)) {
			list = getAllEventsByPort(port);
		}else{
			list = getAllEventsByPortEventType(port, eventType);
		}
		
		return new ListEvents(eventDaoToEvent(list));
	}
	
	public Stock getStock(String port) {
		throw new RuntimeException();
	}
	
	private List<EventDao> getAllEventsByShip(String ship){
		return eventRepository.findAllByShip(ship);
	}
	
	private List<EventDao> getAllEventsByShipEventType(String ship, String eventType){
		return eventRepository.findAllByShipAndEventType(ship, eventType);
	}
	
	private List<EventDao> getAllEventsByPort(String port){
		return eventRepository.findAllByPort(port);
	}
	
	private List<EventDao> getAllEventsByPortEventType(String port, String eventType){
		return eventRepository.findAllByPortAndEventType(port, eventType);
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
