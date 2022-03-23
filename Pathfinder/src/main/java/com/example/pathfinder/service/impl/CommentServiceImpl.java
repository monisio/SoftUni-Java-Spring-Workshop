package com.example.pathfinder.service.impl;

import com.example.pathfinder.model.binding.NewCommentBindingModel;
import com.example.pathfinder.model.entity.CommentEntity;
import com.example.pathfinder.model.entity.RouteEntity;
import com.example.pathfinder.model.entity.UserEntity;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.repository.CommentRepository;
import com.example.pathfinder.repository.RouteRepository;
import com.example.pathfinder.repository.UserRepository;
import com.example.pathfinder.service.CommentService;
import com.example.pathfinder.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, RouteRepository routeRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.routeRepository = routeRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<CommentViewModel> getAllCommentsByRouteId(Long routeId) {

        return commentRepository.findAllByRouteIdOrderByCreatedDesc(routeId)
                .stream()
                .map(c-> modelMapper.map(c, CommentViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentViewModel addNewComment(NewCommentBindingModel newComment, Long routeId, Long userId) {


        UserEntity author = userRepository.findById(userId).orElseThrow(()-> new ObjectNotFoundException(String.format("User with id %s not found", userId)));
        RouteEntity route = routeRepository.findById(routeId).orElseThrow(()-> new ObjectNotFoundException(String.format("User with id %s not found", routeId)));


        CommentEntity comment = new CommentEntity()
                .setApproved(true)
                .setAuthor(author)
                .setRoute(route)
                .setTextContent(newComment.getMessage());

        commentRepository.save(comment);

       return modelMapper.map(comment , CommentViewModel.class);

    }
}

