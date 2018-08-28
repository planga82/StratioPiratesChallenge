package com.challenge.pirates.dao;

import org.springframework.data.repository.CrudRepository;

import com.challenge.pirates.entities.EventReplicaDao;



public interface ReplicaRepository extends CrudRepository<EventReplicaDao, Long> {

   
}