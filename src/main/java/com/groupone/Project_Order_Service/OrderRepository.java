package com.groupone.Project_Order_Service;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface OrderRepository extends ReactiveMongoRepository<Order, String> {
	
}