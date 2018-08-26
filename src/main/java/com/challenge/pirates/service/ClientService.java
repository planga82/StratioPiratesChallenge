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
	
	public ListEvents getListEvents(String ship, String eventType){
		
		List<EventDao> list = null;
		if(eventType.equals(GeneralConstants.EVENT_ALL)) {
			list = getAllEvents(ship);
		}else if(eventType.equals(GeneralConstants.EVENT_ARRIVAL)) {
			
		}else if(eventType.equals(GeneralConstants.EVENT_DEPARTURE)) {
			
		}
		
		
		
		return new ListEvents(eventDaoToEvent(list));
	}
	
	private List<EventDao> getAllEvents(String ship){
		return repository.findAllByShip(ship);
	}
	
	private List<Event> eventDaoToEvent(List<EventDao> list) {
		List<Event> ret = new ArrayList<Event>();
		for (Iterator<EventDao> iterator = list.iterator(); iterator.hasNext();) {
			EventDao eventDao = iterator.next();
			ret.add(new Event(eventDao.getTime(), eventDao.getEventType(), eventDao.getPort(), eventDao.getGoldCoins(), eventDao.getDrimBarrels()));
		}
		return ret;
	}
	
	
}
