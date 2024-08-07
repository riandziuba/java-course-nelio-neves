package com.rdziuba.repositories;

import com.rdziuba.entities.Order;
import com.rdziuba.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
