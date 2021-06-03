package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.springbootdemo.dto.ProductDto;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.services.ProductService;
import ru.itis.springbootdemo.services.UsersService;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UsersService usersService;

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok(
                productService.getAllProducts()
        );
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(
                usersService.getAllUsers()
        );
    }

    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/rest/products/search")
    public ResponseEntity<List<ProductDto>> getProductsLikeName(@RequestParam("q") String q) {
        return ResponseEntity.ok(
                productService.getProductsLikeName(q)
        );
    }

}
