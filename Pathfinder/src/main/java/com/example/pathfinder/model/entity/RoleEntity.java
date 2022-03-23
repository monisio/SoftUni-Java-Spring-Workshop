package com.example.pathfinder.model.entity;

import com.example.pathfinder.model.entity.enums.RoleNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class RoleEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;

    public RoleEntity() {
    }

    public RoleNameEnum getName() {
        return role;
    }

    public RoleEntity setName(RoleNameEnum role) {
        this.role = role;
        return this;
    }
}
