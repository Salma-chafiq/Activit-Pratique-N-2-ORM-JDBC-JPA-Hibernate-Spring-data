package com.example.jpaapvd4a2.service;

import com.example.jpaapvd4a2.entities.Role;
import com.example.jpaapvd4a2.entities.User;
import com.example.jpaapvd4a2.repositories.RoleRepository;
import com.example.jpaapvd4a2.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@Component : c'est generale c'est pour n'import quel couche
//@Service :Pour indiquer a Spring component pour la couche metie
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    //Autowired ou create Constrocter or @AllArgsConstractor
    private UserRepository userRepository ;
    private RoleRepository roleRepository;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());

        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findUserByRoleName(String roleNames) {
        return roleRepository.findByRoleName(roleNames);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = this.findUserByUserName(username);
        Role role =findUserByRoleName(roleName);
        if (user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }//userRepository.save(user);
    }

    @Override
    public User authenticate(String userName, String password) {
        User user =userRepository.findByUsername(userName);
        //On Verifier si le mot de passe est le meme qui existe dans la base de donne
        if(user==null) throw new RuntimeException("Bad credentials");
        if (user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentils");

    }
}
