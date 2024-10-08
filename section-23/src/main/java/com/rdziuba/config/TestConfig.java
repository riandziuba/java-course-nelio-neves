package com.rdziuba.config;

import com.rdziuba.entities.Category;
import com.rdziuba.entities.Order;
import com.rdziuba.entities.OrderItem;
import com.rdziuba.entities.Payment;
import com.rdziuba.entities.Product;
import com.rdziuba.entities.User;
import com.rdziuba.entities.enums.OrderStatus;
import com.rdziuba.repositories.CategoryRepository;
import com.rdziuba.repositories.OrderItemRepository;
import com.rdziuba.repositories.OrderRepository;
import com.rdziuba.repositories.ProductRepository;
import com.rdziuba.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) {
        User userOne = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User userTwo = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(userOne, userTwo));

        Order orderOne = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), userOne, OrderStatus.PAID);
        Order orderTwo = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), userTwo, OrderStatus.WAITING_PAYMENT);
        Order orderThree = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), userOne, OrderStatus.WAITING_PAYMENT);

        orderRepository.saveAll(Arrays.asList(orderOne, orderTwo, orderThree));

        Category categoryOne = new Category(null, "Electronics");
        Category categoryTwo = new Category(null, "Books");
        Category categoryThree = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(categoryOne, categoryTwo, categoryThree));

        Product productOne = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product productTwo = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product productThree = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product productFour = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product productFive = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour, productFive));

        productOne.getCategories().add(categoryTwo);
        productTwo.getCategories().add(categoryOne);
        productTwo.getCategories().add(categoryThree);
        productThree.getCategories().add(categoryThree);
        productFour.getCategories().add(categoryThree);
        productFive.getCategories().add(categoryTwo);

        productRepository.saveAll(Arrays.asList(productOne, productTwo, productThree, productFour, productFive));

        OrderItem OrderItemOne = new OrderItem(orderOne, productOne, 2, productOne.getPrice());
        OrderItem OrderItemTwo = new OrderItem(orderOne, productThree, 1, productThree.getPrice());
        OrderItem OrderItemThree = new OrderItem(orderTwo, productThree, 2, productThree.getPrice());
        OrderItem OrderItemFour = new OrderItem(orderThree, productFive, 2, productFive.getPrice());

        orderItemRepository.saveAll(Arrays.asList(OrderItemOne, OrderItemTwo, OrderItemThree, OrderItemFour));

        Payment paymentOne = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), orderOne);
        orderOne.setPayment(paymentOne);

        orderRepository.save(orderOne);
    }
}
