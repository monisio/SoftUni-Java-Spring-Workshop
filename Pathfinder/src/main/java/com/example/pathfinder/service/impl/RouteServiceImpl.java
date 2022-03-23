package com.example.pathfinder.service.impl;


import com.example.pathfinder.model.entity.PictureEntity;
import com.example.pathfinder.model.entity.RouteEntity;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.model.view.RouteBasicViewModel;
import com.example.pathfinder.model.view.RouteDetailsViewModel;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.service.CategoryService;
import com.example.pathfinder.service.RouteService;
import com.example.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    private final UserService userService;
    private final CategoryService categoryService;


    public RouteServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;


        this.categoryService = categoryService;
    }

    @Override
    public List<RouteBasicViewModel> findAllRoutes() {

        // return modelMapper.map(this.routeRepository.getAll(), new TypeToken<List<RouteBasicViewModel>>() {}.getType());

        return routeRepository.findAll().stream().map(route -> {
            RouteBasicViewModel routeView = modelMapper.map(route, RouteBasicViewModel.class);
            routeView.setPictureUrl(route.getPictures().stream().findAny().orElse(new PictureEntity().setUrl("/images/pic4.jpg")).getUrl());
            return routeView;
        }).collect(Collectors.toList());
    }

    @Override
    public void addNewRoute(RouteServiceModel routeServiceModel) {
        RouteEntity route = modelMapper.map(routeServiceModel, RouteEntity.class);

        //TODO add logged user to new route

       // route.setAuthor(userService.findCurrentUserEntity());

        route.setCategories(routeServiceModel.getCategories().stream().map(categoryService::getCategoryByCategoryEnum).collect(Collectors.toSet()));

        routeRepository.save(route);
    }

    @Override
    public RouteDetailsViewModel findRouteById(Long id) {


        Optional<RouteEntity> byId = routeRepository.findById(id);


        return  modelMapper.map(byId.get(), RouteDetailsViewModel.class);
    }

}
