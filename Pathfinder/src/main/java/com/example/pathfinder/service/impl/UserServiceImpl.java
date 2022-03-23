package com.example.pathfinder.service.impl;


import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.model.entity.enums.LevelEnum;
import com.example.pathfinder.model.entity.enums.RoleNameEnum;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.repository.RoleRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final  ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;

        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void register(UserServiceModel userServiceModel) {
        //TODO to fix this non-sense
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setLevel(LevelEnum.BEGINNER);
        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));
        user.setRoles(Set.of(roleRepository.findByRole(RoleNameEnum.USER)));
        userRepository.save(user);
    }

    @Override
    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {

        return this.userRepository
                .findByUsernameAndPassword(username, password)
                .map(userEntity -> this.modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);

    }


    @Override
    public UserServiceModel findById(Long id) {
        return this.userRepository.findById(id).map(user->modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }


}
