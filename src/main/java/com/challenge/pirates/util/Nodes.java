package com.challenge.pirates.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Component;


@Component
public class Nodes {

	private static final String NODES_FILE = "nodes.properties";
	private static final String ACTUAL_PROPERTY = "actual";
	private static final String NODES_PROPERTY = "nodes";
	private static final String SEPARATOR = ",";
	
	private List<String> hostPort=new ArrayList<String>();
	
	public Nodes() throws IOException {
		Properties prop = new Properties();		
		prop.load(Nodes.class.getClassLoader().getResourceAsStream(NODES_FILE));
		hostPort.addAll(Arrays.asList(prop.getProperty(NODES_PROPERTY).split(SEPARATOR)));
		hostPort.remove(prop.getProperty(ACTUAL_PROPERTY));
	}
	

	public List<String> getHostPort() {
		return hostPort;
	}

	
	
	
	
	

}
