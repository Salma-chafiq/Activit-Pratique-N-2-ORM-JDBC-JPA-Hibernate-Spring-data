package com.example.jpaapvd4a2.repositories;

import com.example.jpaapvd4a2.entities.Role;
import com.example.jpaapvd4a2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repotory n'est pas oblicatoire car deja exit jpa
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName );
}
