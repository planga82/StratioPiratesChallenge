package com.challenge.pirates.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StockDao implements Serializable{

	private static final long serialVersionUID = -7740444078502066724L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String  port;
	
	@Column
	private Long goldCoins;
	
	@Column
	private Long drimBarrels;
	
	

	public StockDao() {
		super();
	}

	

	public StockDao(Long id, String port, Long goldCoins, Long drimBarrels) {
		super();
		this.id = id;
		this.port = port;
		this.goldCoins = goldCoins;
		this.drimBarrels = drimBarrels;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
