package com.example.pathfinder.service.impl.user;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class PathFinderUser extends User {

    private final Long id;

    public PathFinderUser(Long id,String username, String password, Collection<? extends GrantedAuthority> authorities) {

        super(username, password, authorities);
        this.id = id;
    }

    public PathFinderUser(Long id ,String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
    }


    public Long getId() {
        return id;
    }


}
