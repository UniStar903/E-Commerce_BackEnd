package com.precize.e_commerce.repository;

import com.precize.e_commerce.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}