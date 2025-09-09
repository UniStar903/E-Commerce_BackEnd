package com.precize.e_commerce.repository;

import com.precize.e_commerce.events.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Event, String> {
}
