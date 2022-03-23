package com.example.pathfinder.service;


import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteBasicViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;

import java.util.List;

public interface RouteService {

    List<RouteBasicViewModel> findAllRoutes();

    void addNewRoute(RouteServiceModel routeServiceModel);

    RouteDetailsViewModel findRouteById(Long id);

}
