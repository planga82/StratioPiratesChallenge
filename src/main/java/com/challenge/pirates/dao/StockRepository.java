package com.challenge.pirates.dao;

import org.springframework.data.repository.CrudRepository;

import com.challenge.pirates.entities.StockDao;

public interface StockRepository extends CrudRepository<StockDao, Long> {

	StockDao findByPort(String port);
    
}