package com.boot.project.service;


import java.util.List;

import com.boot.project.model.Reserve;
import com.boot.project.model.User;

public interface UserService {
    User saveUser(User user);
    Reserve saveMyUser(Reserve reserve);

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUsername(String username);

    List<User> findAllUsers();

    Long numberOfUsers();
}
