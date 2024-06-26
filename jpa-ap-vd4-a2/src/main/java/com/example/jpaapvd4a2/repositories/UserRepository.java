package com.example.jpaapvd4a2.repositories;

import com.example.jpaapvd4a2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);

}
