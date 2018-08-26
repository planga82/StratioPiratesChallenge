package com.challenge.pirates.domain;



public class Stock extends JsonResult{
	
	private String  port;
	
	private Long goldCoins;
	
	private Long drimBarrels;
	
	

	public Stock() {
		super();
	}

	

	public Stock(String port, Long goldCoins, Long drimBarrels) {
		super();
		this.port = port;
		this.goldCoins = goldCoins;
		this.drimBarrels = drimBarrels;
	}
	

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Long getGoldCoins() {
		return goldCoins;
	}

	public void setGoldCoins(Long goldCoins) {
		this.goldCoins = goldCoins;
	}

	public Long getDrimBarrels() {
		return drimBarrels;
	}

	public void setDrimBarrels(Long drimBarrels) {
		this.drimBarrels = drimBarrels;
	}

	
	
}
