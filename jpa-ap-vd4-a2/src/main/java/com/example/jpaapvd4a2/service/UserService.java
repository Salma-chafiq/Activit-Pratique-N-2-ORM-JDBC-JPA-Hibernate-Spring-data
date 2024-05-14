package com.example.jpaapvd4a2.service;

import com.example.jpaapvd4a2.entities.Role;
import com.example.jpaapvd4a2.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName (String UserNames);
    Role findUserByRoleName (String roleNames);
    void addRoleToUser(String username ,String roleName);
    User authenticate (String userName ,String password);

}
