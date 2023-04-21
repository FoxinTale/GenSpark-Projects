package org.clientproject.Services;

import org.clientproject.DAO.UserDAO;
import org.clientproject.Entity.UserEntity;
import org.clientproject.ServiceInterfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {
    private UserDAO userDAO;
    private UserEntity user;

    @Override
    public List<UserEntity> getAllUsers() {
        return this.userDAO.findAll();
    }

    @Override
    public UserEntity getUserByID(int userID) {
        Optional<UserEntity> userList = this.userDAO.findById(userID);

        UserEntity userEntity = null;

        if(userList.isPresent()){
            userEntity = userList.get();
        } else {
            throw new RuntimeException("There is no User found for id: " + userID);
        }

        return userEntity;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return this.userDAO.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) {
        return this.userDAO.save(user);
    }

    @Override
    public String deleteUserByID(int userID) {
        this.userDAO.deleteById(userID);
        return "User has been deleted";
    }
}
