package com.challenge.pirates.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pirates.domain.ErrorResponse;
import com.challenge.pirates.domain.JsonResult;
import com.challenge.pirates.service.ClientService;
import com.challenge.pirates.util.GeneralConstants;


@RestController
@RequestMapping({ GeneralConstants.URL_BASE + "/client/"})
public class ClientController {

	private static final Logger LOGGER = Logger.getLogger( ClientController.class.getName() );

	@Autowired
	private ClientService service;
	
	@CrossOrigin
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> test(){
		LOGGER.info("> Controller.test");
		return ResponseEntity.ok("REST Interface UP\n");
	}
	
	@CrossOrigin
	@GetMapping(path = "/travelHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResult> travelHistory(@RequestParam String shipId, @RequestParam String eventType){
		try {
			if(!service.existShip(shipId)) {
				LOGGER.severe("The ship does not exist: " + shipId);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10001));
			}else if(!validateEventType(eventType)) {
				LOGGER.severe("Invalid event type: " + eventType);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10002));
			}else {
				return ResponseEntity.ok((JsonResult)service.getListEventsByShip(shipId,eventType));	
			}
			
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, GeneralConstants.INTERNAL_SERVER_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10000));
		}
	}
	
	@CrossOrigin
	@GetMapping(path = "/portHistory", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResult> portHistory(@RequestParam String portId, @RequestParam String eventType){
		try {
			if(!service.existPort(portId)) {
				LOGGER.severe("The ship does not exist: " + portId);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10003));
			}else if(!validateEventType(eventType)) {
				LOGGER.severe("Invalid event type: " + eventType);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10004));
			}else {
				return ResponseEntity.ok((JsonResult)service.getListEventsByPort(portId,eventType));	
			}
			
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, GeneralConstants.INTERNAL_SERVER_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10000));
		}
	}
	
	private boolean validateEventType(String eventType) {
		return eventType.equals(GeneralConstants.EVENT_ARRIVAL) || eventType.equals(GeneralConstants.EVENT_DEPARTURE) || eventType.equals(GeneralConstants.EVENT_ALL);
	}
	
	
}
