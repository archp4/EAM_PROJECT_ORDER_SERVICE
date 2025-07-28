package com.groupone.Project_Order_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
	
	@LoadBalanced
	@Bean
	RestTemplate restTeamplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private OrderRepository repository;

	public Flux<Order> getOrders() {
		return repository.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Order> save(final Order orderModel) {
	    Market marketRequest = new Market();
	    marketRequest.setStockSymbol(orderModel.getStockSymbol());
	    marketRequest.setPrice(orderModel.getTotalPrice() / orderModel.getQty());
	    marketRequest.setAvailableQty(orderModel.getQty());
	    marketRequest.setListedExchangeName("TSX");
	    String marketServiceUrl = "http://market-service/markets";
	    restTemplate.postForEntity(marketServiceUrl, marketRequest, String.class);
		return repository.save(orderModel);
	}

	public Mono<Order> update(final Order orderModel) {
		return repository.findById(orderModel.getOrderID()).flatMap(existingOrder -> {
			existingOrder.setUserId(orderModel.getUserId());
			existingOrder.setStockSymbol(orderModel.getStockSymbol());
			existingOrder.setQty(orderModel.getQty());
			existingOrder.setTotalPrice(orderModel.getTotalPrice());
			existingOrder.setStatus(orderModel.getStatus());
			existingOrder.setOrderType(orderModel.getOrderType());
			return repository.save(existingOrder);
		}).switchIfEmpty(Mono.error(new RuntimeException("Order not found with ID: " + orderModel.getOrderID())));

	}

}
