package com.challenge.pirates.controller;


import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.pirates.domain.ListEvents;
import com.challenge.pirates.domain.Stock;
import com.challenge.pirates.service.ClientService;
import com.challenge.pirates.util.GeneralConstants;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "security.basic.enabled=false"
})
@AutoConfigureMockMvc(secure = false)
public class ClientControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ClientService service;
	
	@Test
	public void traveHistoryOk() throws Exception {
		
		given(service.existShip(Mockito.anyString())).willReturn(true);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByShip(Mockito.anyString(),Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/travelHistory").contentType(APPLICATION_JSON).param("shipId", "1").param("eventType", GeneralConstants.EVENT_ARRIVAL))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void traveHistoryNotExistShip() throws Exception {
		
		given(service.existShip(Mockito.anyString())).willReturn(false);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByShip(Mockito.anyString(), Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/travelHistory").contentType(APPLICATION_JSON).param("shipId", "1").param("eventType", GeneralConstants.EVENT_ARRIVAL))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void traveHistoryInvalidTypeEvent() throws Exception {
		
		given(service.existShip(Mockito.anyString())).willReturn(true);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByShip(Mockito.anyString(),Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/travelHistory").contentType(APPLICATION_JSON).param("shipId", "1").param("eventType", "XXXX"))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}

	
	@Test
	public void traveHistoryPortOk() throws Exception {
		
		given(service.existPort(Mockito.anyString())).willReturn(true);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByPort(Mockito.anyString(),Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/portHistory").contentType(APPLICATION_JSON).param("portId", "1").param("eventType", GeneralConstants.EVENT_ARRIVAL))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void traveHistoryPortNotExistPort() throws Exception {
		
		given(service.existPort(Mockito.anyString())).willReturn(false);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByPort(Mockito.anyString(), Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/portHistory").contentType(APPLICATION_JSON).param("portId", "1").param("eventType", GeneralConstants.EVENT_ARRIVAL))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void traveHistoryPortInvalidTypeEvent() throws Exception {
		
		given(service.existPort(Mockito.anyString())).willReturn(true);
		Mockito.doReturn(new ListEvents()).when(service).getListEventsByPort(Mockito.anyString(),Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/portHistory").contentType(APPLICATION_JSON).param("portId", "1").param("eventType", "XXXX"))
		.andDo(print())
		.andExpect(status().isBadRequest());
	}
	
	@Test
	public void stockOk() throws Exception {
		
		given(service.existPort(Mockito.anyString())).willReturn(true);
		Mockito.doReturn(new Stock()).when(service).getStock(Mockito.anyString());
		
		mvc.perform(get(GeneralConstants.URL_BASE + "/client/portStock").contentType(APPLICATION_JSON).param("portId", "1"))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
