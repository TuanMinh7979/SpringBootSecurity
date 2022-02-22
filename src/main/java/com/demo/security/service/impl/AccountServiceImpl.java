package com.demo.security.service.impl;

import com.demo.security.models.Account;
import com.demo.security.models.Role;
import com.demo.security.repo.AccountRepo;
import com.demo.security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;


    @Override
    public Account save(Account acc) {
        return accountRepo.save(acc);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepo.findAccountByUserName(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        if (account == null) {
            throw new UsernameNotFoundException("username not found");
        } else {
            for (Role role : account.getRole()) {
                grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
            }
        }

        return new User(account.getUserName(), account.getPassword(), grantedAuthorityList);
    }
}
