package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.RoleEntity;
import com.example.pathfinder.model.entity.enums.RoleNameEnum;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {


    RoleEntity findByRole(RoleNameEnum role);
}
