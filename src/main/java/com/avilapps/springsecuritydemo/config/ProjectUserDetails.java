package com.avilapps.springsecuritydemo.config;

import com.avilapps.springsecuritydemo.data.entities.Customer;
import com.avilapps.springsecuritydemo.data.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectUserDetails implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public ProjectUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("User details not found the user: " + username);
        }

        Customer customer = customers.get(0);
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));

        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}
