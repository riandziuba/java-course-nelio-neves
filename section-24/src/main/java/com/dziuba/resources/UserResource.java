package com.dziuba.resources;

import com.dziuba.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User user = new User("123456", "Rian", "rian@gmail.com");
        User user2 = new User("123456", "Mateus", "mateus@gmail.com");
        List<User> users = List.of(user, user2);
        return ResponseEntity.ok(users);
    }
}
