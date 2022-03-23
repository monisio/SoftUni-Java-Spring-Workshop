package com.example.pathfinder.repository;

import com.example.pathfinder.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<CommentEntity> findAllByRouteIdOrderByCreatedDesc(Long routeId);

}
