package com.challenge.pirates.controller;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.pirates.domain.ErrorResponse;
import com.challenge.pirates.domain.Event;
import com.challenge.pirates.domain.InitialStock;
import com.challenge.pirates.domain.JsonResult;
import com.challenge.pirates.domain.SuccessResponse;
import com.challenge.pirates.entities.EventDao;
import com.challenge.pirates.service.GeneralService;
import com.challenge.pirates.util.GeneralConstants;


@RestController
@RequestMapping({ GeneralConstants.URL_BASE + "/internal/"})
public class InternalController {

	private static final Logger LOGGER = Logger.getLogger( InternalController.class.getName() );

	@Autowired
	private GeneralService service;
	
	@CrossOrigin
	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> test(){
		LOGGER.info("> Controller.test");
		return ResponseEntity.ok("REST Interface UP\n");
	}
	
	@CrossOrigin
	@PostMapping(path = "/newEvent", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResult> newEvent(@RequestBody Event event){
		try {
			/*
			 * Como es un servicio interno, no voy a realizar la validación de los campos de entrada
			 * En un sistema real si habría que realizarlas al estilo de la clase ClientController
			 */
			service.createEventAndUpdateStock(event);
			return ResponseEntity.status(HttpStatus.CREATED).body((JsonResult)new SuccessResponse(GeneralConstants.SUCCESS_CREATED));
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, GeneralConstants.INTERNAL_SERVER_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10000));
		}
	}
	
	@CrossOrigin
	@PostMapping(path = "/uptadeReplica", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResult> uptadeReplica(@RequestBody EventDao event){
		try {
			/*
			 * Como es un servicio interno, no voy a realizar la validación de los campos de entrada
			 * En un sistema real si habría que realizarlas al estilo de la clase ClientController
			 */
			service.createEventAndUpdateStockReplica(event);
			return ResponseEntity.status(HttpStatus.CREATED).body((JsonResult)new SuccessResponse(GeneralConstants.SUCCESS_CREATED));
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, GeneralConstants.INTERNAL_SERVER_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10000));
		}
	}
	
	@CrossOrigin
	@PostMapping(path = "/loadInitialStock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<JsonResult> loadInitialStock(@RequestBody InitialStock stockList){
		try {
			/*
			 * Como es un servicio interno, no voy a realizar la validación de los campos de entrada
			 * En un sistema real si habría que realizarlas al estilo de la clase ClientController
			 */
			service.loadInitialStock(stockList);
			return ResponseEntity.status(HttpStatus.CREATED).body((JsonResult)new SuccessResponse(GeneralConstants.SUCCESS_CREATED));
		}catch (Exception e) {
			LOGGER.log(Level.SEVERE, GeneralConstants.INTERNAL_SERVER_ERROR, e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((JsonResult)new ErrorResponse(GeneralConstants.CODE_10000));
		}
	}
	
	
	@CrossOrigin
	@GetMapping(path = "/getAllUUIDs", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<String>> getAllUUIDs(@RequestParam Long time){
		
			/*
			 * Como es un servicio interno, no voy a realizar la validación de los campos de entrada
			 * En un sistema real si habría que realizarlas al estilo de la clase ClientController
			 */
			return ResponseEntity.ok(service.getAllUUIDs(time));
		
	}
	
	
}
