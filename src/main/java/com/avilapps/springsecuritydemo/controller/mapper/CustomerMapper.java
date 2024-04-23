package com.avilapps.springsecuritydemo.controller.mapper;

import com.avilapps.springsecuritydemo.controller.dto.CustomerDTO;
import com.avilapps.springsecuritydemo.data.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer mapCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setPwd(customerDTO.getPassword());
        customer.setRole("user");
        return customer;
    }
}
