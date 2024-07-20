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
import java.util.Optional;

@Service
public class ProjectUserDetails implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public ProjectUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optCustomer = customerRepository.findByEmail(username).stream().findFirst();

        if (optCustomer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found the user: " + username);
        }

        Customer customer = optCustomer.get();
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));

        return new User(customer.getEmail(), customer.getPwd(), authorities);
    }
}
