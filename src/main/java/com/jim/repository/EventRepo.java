package com.jim.repository;

import org.springframework.data.repository.CrudRepository;

import com.jim.model.Event;

public interface EventRepo extends CrudRepository<Event, Integer> {

}
