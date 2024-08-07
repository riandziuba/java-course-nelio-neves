package com.rdziuba.services;

import com.rdziuba.entities.Order;
import com.rdziuba.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> userOptional = orderRepository.findById(id);
        return userOptional.get();
    }
}
