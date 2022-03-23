package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.impl.user.PathFinderUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PathFinderUserService implements UserDetailsService {

    private final UserRepository userRepository;


    public PathFinderUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        UserEntity user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Incorrect username/password!"));

        return this.mapUserToUserDetails(user);
    }

    private UserDetails mapUserToUserDetails(UserEntity user) {

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(r-> new SimpleGrantedAuthority("ROLE_"+ r.getName())).collect(Collectors.toList());


        return new PathFinderUser(user.getId(),user.getUsername(),user.getPassword(),authorities);

    }
}
