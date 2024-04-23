package com.avilapps.springsecuritydemo.domain;

import com.avilapps.springsecuritydemo.data.entities.Customer;
import com.avilapps.springsecuritydemo.data.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final CustomerRepository customerRepository;

    public UserService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void registerUser(Customer customer) {
        customerRepository.save(customer);
    }
}
