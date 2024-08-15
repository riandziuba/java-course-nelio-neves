package com.rdziuba.config;

import com.rdziuba.entities.Order;
import com.rdziuba.entities.User;
import com.rdziuba.entities.enums.OrderStatus;
import com.rdziuba.repositories.OrderRepository;
import com.rdziuba.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) {
        User userOne = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User userTwo = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(userOne, userTwo));

        Order orderOne = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), userOne, OrderStatus.PAID);
        Order orderTwo = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), userTwo, OrderStatus.WAITING_PAYMENT);
        Order orderThree = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), userOne, OrderStatus.WAITING_PAYMENT);

        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo, orderThree));
    }
}
