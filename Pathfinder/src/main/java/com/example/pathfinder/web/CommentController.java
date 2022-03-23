package com.example.pathfinder.web;


import com.example.pathfinder.model.binding.NewCommentBindingModel;
import com.example.pathfinder.service.CommentService;
import com.example.pathfinder.service.impl.user.PathFinderUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/routes/{routeId}/add-comment")
    public String routesCommentAdd(@Valid @ModelAttribute("message")NewCommentBindingModel comment, BindingResult bindingResult , @PathVariable Long routeId , @AuthenticationPrincipal PathFinderUser user){

            if(!bindingResult.hasErrors()){
                this.commentService.addNewComment( comment , routeId , user.getId() );
            }


        return "redirect:/routes/"+ routeId;

    }



}
