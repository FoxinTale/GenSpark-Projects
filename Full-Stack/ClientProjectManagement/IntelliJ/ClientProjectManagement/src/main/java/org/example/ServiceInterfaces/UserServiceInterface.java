package org.example.ServiceInterfaces;

import org.example.Entity.UserEntity;

import java.util.List;

public interface UserServiceInterface {

    List<UserEntity> getAllUsers();

    UserEntity getUserByID(int userID);

    UserEntity addUser(UserEntity user);

    UserEntity updateUser(UserEntity user);

    String deleteUserByID(int userID);
}
