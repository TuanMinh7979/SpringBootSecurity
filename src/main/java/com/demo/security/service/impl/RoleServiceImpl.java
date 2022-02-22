package com.demo.security.service.impl;

import com.demo.security.models.Role;
import com.demo.security.repo.RoleRepo;
import com.demo.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Iterable<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findById(int id) {
        return roleRepo.findById(id).get();
    }
}
