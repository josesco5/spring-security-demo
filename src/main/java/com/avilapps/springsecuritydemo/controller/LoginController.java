package com.avilapps.springsecuritydemo.controller;

import com.avilapps.springsecuritydemo.controller.dto.CustomerDTO;
import com.avilapps.springsecuritydemo.controller.mapper.CustomerMapper;
import com.avilapps.springsecuritydemo.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;
    private final CustomerMapper customerMapper;

    public LoginController(UserService userService, CustomerMapper customerMapper) {
        this.userService = userService;
        this.customerMapper = customerMapper;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody CustomerDTO customer) {
        userService.registerUser(customerMapper.mapCustomer(customer));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Given user details are successfully registered");
    }
}
