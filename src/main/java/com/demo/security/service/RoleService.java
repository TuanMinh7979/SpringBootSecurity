package com.demo.security.service;

import com.demo.security.models.Role;

public interface RoleService {
    Iterable<Role> findAll();
    Role findById(int id);
}
