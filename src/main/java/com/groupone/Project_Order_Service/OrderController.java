package com.groupone.Project_Order_Service;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public Flux<Order> getAllOrders() {
		return orderService.getOrders();
	}

	@PostMapping
	public Mono<Order> createOrder(@RequestBody Order order) {
		Mono<Order> temp = orderService.save(order);
		System.out.println("Order Detail Stored");
		System.out.println("Requested Stock Reservation");
		System.out.println("Recorded Reserved Stcok into Account");
		System.out.println("Requesting Fee");
		System.out.println("Order Place");
		return temp;
	}

	@PutMapping("/{orderId}")
	public Mono<ResponseEntity<Order>> updateOrder(@PathVariable String orderId, @RequestBody Order order) {
		order.setOrderID(orderId);
		return orderService.update(order).map(updatedOrder -> ResponseEntity.ok(updatedOrder))
				.onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
	}

}
