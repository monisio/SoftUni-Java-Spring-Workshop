package com.example.pathfinder.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

    private boolean approved;
    @Column(nullable = false)
    private LocalDateTime created;
    @Column(columnDefinition = "TEXT")
    private String textContent;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity author;
    @ManyToOne(fetch = FetchType.EAGER)
    private RouteEntity route;

    public CommentEntity() {
    }


    public boolean isApproved() {
        return approved;
    }

    public CommentEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentEntity setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public CommentEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }

    @PrePersist
    private void setCreateDateAndTime(){
        this.setCreated(LocalDateTime.now());
    }
}

