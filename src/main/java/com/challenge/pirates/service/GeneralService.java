package com.challenge.pirates.service;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.pirates.dao.EventsRepository;
import com.challenge.pirates.dao.StockRepository;
import com.challenge.pirates.domain.Event;
import com.challenge.pirates.domain.InitialStock;
import com.challenge.pirates.domain.ListEvents;
import com.challenge.pirates.domain.Stock;
import com.challenge.pirates.entities.EventDao;
import com.challenge.pirates.entities.StockDao;
import com.challenge.pirates.exceptions.PiratesException;
import com.challenge.pirates.util.GeneralConstants;




@Service
public class GeneralService {

	private static final Logger LOGGER = Logger.getLogger( GeneralService.class.getName() );
	
	@Autowired
	EventsRepository eventRepository;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	ReplicasService replicasService;
		
	
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
		return stockDaoToStock(stockRepository.findByPort(port));
	}
	
	
	public void createEventAndUpdateStock(Event event) throws PiratesException, InterruptedException {
		EventDao eventSaved = updateBBDD(event);
		replicasService.updateReplicas(eventSaved);
		LOGGER.info("createEventAndUpdateStock finished");
	}
	
	public void createEventAndUpdateStockReplica(EventDao event) throws PiratesException, InterruptedException {
		event.setId(null);
		eventRepository.save(event);
		updateStock(new Event(event.getTime().toString(), event.getEventType(), event.getPort(), event.getShip(), event.getGoldCoins(), event.getDrimBarrels()));
	}
	
	@Transactional
	public EventDao updateBBDD(Event event) throws PiratesException {
		EventDao eventSaved = updateEvent(event);
		updateStock(event);
		return eventSaved;
	}
	
	private EventDao updateEvent(Event event) {
		String uuid = UUID.randomUUID().toString();
		return eventRepository.save(eventToEventDao(event,uuid));		
	}
	
	private void updateStock(Event event) throws PiratesException {
		StockDao stock = stockRepository.findByPort(event.getPortId());
		
		if(event.getEventType().equals(GeneralConstants.EVENT_ARRIVAL)){
			stock.setDrimBarrels(stock.getDrimBarrels()+event.getDrumBarrels());
			stock.setGoldCoins(stock.getGoldCoins()+event.getGoldCoins());
		}else if(event.getEventType().equals(GeneralConstants.EVENT_DEPARTURE)){
			stock.setDrimBarrels(stock.getDrimBarrels()-event.getDrumBarrels());
			stock.setGoldCoins(stock.getGoldCoins()-event.getGoldCoins());
		}else {
			throw new PiratesException("Invalid type of event");
		}
		
		stockRepository.save(stock);
	}
	
	public void loadInitialStock(InitialStock stockList) {
		stockRepository.saveAll(stockTostockDao(stockList.getStockList()));
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
		List<Event> ret = new ArrayList<>();
		for (Iterator<EventDao> iterator = list.iterator(); iterator.hasNext();) {
			EventDao eventDao = iterator.next();
			ret.add(new Event(eventDao.getTime().toString(), eventDao.getEventType(), eventDao.getPort(), eventDao.getShip(), eventDao.getGoldCoins(), eventDao.getDrimBarrels()));
		}
		return ret;
	}
	
	private List<StockDao> stockTostockDao(List<Stock> list) {
		List<StockDao> ret = new ArrayList<>();
		for (Iterator<Stock> iterator = list.iterator(); iterator.hasNext();) {
			Stock stock = iterator.next();
			ret.add(new StockDao(null, stock.getPort(), stock.getGoldCoins(), stock.getDrimBarrels()));
		}
		return ret;
	}
	
	private Stock stockDaoToStock(StockDao sotckDao) {
		return new Stock(sotckDao.getPort(), sotckDao.getGoldCoins(), sotckDao.getDrimBarrels());
	}
	
	private EventDao eventToEventDao(Event event, String uuid) {
		return new EventDao(null,uuid, event.getEventType(), event.getShipId(), event.getPortId(), event.getGoldCoins(), event.getDrumBarrels(), Long.parseLong(event.getTimeStamp()));
	}
	
	
	public List<String> getAllUUIDs(Long time){
		return eventRepository.findAllUUID(time);
	}
	
	
}
