package com.avilapps.springsecuritydemo.domain;

import com.avilapps.springsecuritydemo.data.entities.Customer;
import com.avilapps.springsecuritydemo.data.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public UserService(PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    public void registerUser(Customer customer) {
        String hashedPassword = passwordEncoder.encode(customer.getPwd());
        customer.setPwd(hashedPassword);
        customerRepository.save(customer);
    }
}
