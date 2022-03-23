package com.example.pathfinder.model.view;



public class RouteBasicViewModel {

    private Long id;
    private String name;
    private String description;
    private String pictureUrl;

    public RouteBasicViewModel() {
    }


    public String getName() {
        return name;
    }

    public RouteBasicViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RouteBasicViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteBasicViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public RouteBasicViewModel setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        return this;
    }
}
