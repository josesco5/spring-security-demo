package com.avilapps.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccounts")
    public String getAccountDetails() {
        return "Here are the account details from the BD";
    }
}
