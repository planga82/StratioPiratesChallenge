package com.challenge.pirates.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challenge.pirates.entities.EventDao;

public interface EventsRepository extends CrudRepository<EventDao, Long> {

    List<EventDao> findAllByShip(String ship);
    
    @Query(nativeQuery=true, value="select * from EVENT_DAO e where e.ship = :ship and e.EVENT_TYPE = :eventType")
    List<EventDao> findAllByShipAndEventType(@Param("ship") String ship, @Param("eventType") String eventType);
    
    List<EventDao> findAllByPort(String port);
    
    @Query(nativeQuery=true, value="select * from EVENT_DAO e where e.port = :port and e.EVENT_TYPE = :eventType")
    List<EventDao> findAllByPortAndEventType(@Param("port") String port, @Param("eventType") String eventType);
    
    Boolean existsByShip(String ship);
    
    Boolean existsByPort(String port);
}