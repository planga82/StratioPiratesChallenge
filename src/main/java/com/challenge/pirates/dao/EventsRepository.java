package com.challenge.pirates.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.challenge.pirates.entities.EventDao;

public interface EventsRepository extends CrudRepository<EventDao, Long> {

    List<EventDao> findAllByShip(String ship);
    
    Boolean existsByShip(String ship);
}