package com.challenge.pirates.service;


import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.pirates.dao.ReplicaRepository;
import com.challenge.pirates.domain.Event;
import com.challenge.pirates.domain.JsonResult;
import com.challenge.pirates.entities.EventReplicaDao;
import com.challenge.pirates.util.GeneralConstants;
import com.challenge.pirates.util.Nodes;




@Service
public class ReplicasService {

	private static final Logger LOGGER = Logger.getLogger( ReplicasService.class.getName() );
	
	@Autowired
	ReplicaRepository replicaRepository;
	
	@Autowired
	Nodes nodes;
	
	
	@Async
	public CompletableFuture<Integer> updateReplicas( Event event) throws InterruptedException {
		for (String hostport : nodes.getHostPort()) {
			updateReplicaOtherNodes(hostport,event);
		}
		return CompletableFuture.completedFuture(1);
	}
	
	@Async
	public CompletableFuture<Integer> updateReplicaOtherNodes(String hostport, Event event) throws InterruptedException {
		RestTemplate restTemplate = new RestTemplate();
		HttpStatus result= HttpStatus.BAD_REQUEST;
		boolean success = false;
		for (int i = 0; i < GeneralConstants.replicaRetries; i++) {
			try {
				LOGGER.info("Updating replica:" + hostport);
				ResponseEntity<JsonResult> resp = restTemplate.postForEntity("http://" + hostport + GeneralConstants.URL_BASE + "/internal/newEvent", event,JsonResult.class);
				result = resp.getStatusCode(); 
				if(result.is2xxSuccessful()) {
					success = true;
					break;
				}
			}catch(Exception e) {
				LOGGER.info("Replica failed");
			}
			Thread.sleep(5000);
		}
		
		if(!success) {
			LOGGER.info("Replica failed, save for batch update");
			saveReplicaForLater(event, hostport);
		}
		return CompletableFuture.completedFuture(1);
		
	}
	
	private void saveReplicaForLater(Event event, String hostport) {
		replicaRepository.save(eventToEventReplicaDao(event, hostport));
	}
		
	
	private EventReplicaDao eventToEventReplicaDao(Event event, String hostport) {
		return new EventReplicaDao(null, event.getEventType(), event.getShipId(), event.getPortId(), event.getGoldCoins(), event.getDrumBarrels(), event.getTimeStamp(),hostport);
	}
	
	
}
