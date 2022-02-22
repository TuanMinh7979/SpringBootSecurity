package com.demo.security.service;

import com.demo.security.models.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account save(Account acc);
}
