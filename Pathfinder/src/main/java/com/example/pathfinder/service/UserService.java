package com.example.pathfinder.service;



import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.model.service.UserServiceModel;

public interface UserService {

    void register(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username , String password);


    UserServiceModel findById(Long id);



}
