package com.example.pathfinder.service;


import com.example.pathfinder.model.binding.NewCommentBindingModel;
import com.example.pathfinder.model.view.CommentViewModel;

import java.util.List;

public interface CommentService {


   List<CommentViewModel> getAllCommentsByRouteId(Long routeId);



   CommentViewModel addNewComment(NewCommentBindingModel message, Long routeId, Long userId);

}
