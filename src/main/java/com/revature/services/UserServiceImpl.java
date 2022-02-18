package com.revature.services;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository ur;

    @Override
    public Optional<User> authenticate(String username, String password) {
        return Optional.empty();
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    /**
     * This method is used to get all of the users in the database.
     *
     * @return                 a list of all the users
     */
    @Override
    public List<User> getAllUsers() {
        return (List<User>) ur.findAll();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}