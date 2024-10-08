package com.rdziuba.resources;

import com.rdziuba.entities.Product;
import com.rdziuba.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> users = productService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        Product user = productService.findById(id);
        return ResponseEntity.ok().body(user);
    }


}
