package com.example.pathfinder.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity{

    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String url;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserEntity author;
    @ManyToOne(fetch = FetchType.EAGER)
    private RouteEntity route;

    public PictureEntity() {
    }

    public String getTitle() {
        return title;
    }

    public PictureEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public PictureEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public PictureEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }
}
