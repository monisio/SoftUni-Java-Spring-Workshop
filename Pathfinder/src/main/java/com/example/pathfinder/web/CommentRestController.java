package com.example.pathfinder.web;


import com.example.pathfinder.model.binding.NewCommentBindingModel;
import com.example.pathfinder.model.validation.ApiError;
import com.example.pathfinder.model.view.CommentViewModel;
import com.example.pathfinder.service.CommentService;
import com.example.pathfinder.service.impl.user.PathFinderUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class CommentRestController {


    public final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }


    @GetMapping("/api/comments/{routeId}/all")
    public ResponseEntity<List<CommentViewModel>> comments(@PathVariable("routeId") Long routeId) {

        return ResponseEntity.ok(this.commentService.getAllCommentsByRouteId(routeId));

    }


    @PostMapping("/api/comments/{routeId}/add-comment")
    public ResponseEntity<CommentViewModel> addComment(
            @AuthenticationPrincipal PathFinderUser principal,
            @PathVariable Long routeId,
            @RequestBody @Valid NewCommentBindingModel newCommentBindingModel
    ) {


        CommentViewModel newComment = commentService.addNewComment(newCommentBindingModel, routeId, principal.getId());
        URI newCommentUri = URI.create(String.format("/api/%s/comments/%s", routeId, newComment.getId()));

        return ResponseEntity.created(newCommentUri).body(newComment);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> onValidationFailure(MethodArgumentNotValidException exception) {

        ApiError apiErrors = new ApiError(HttpStatus.BAD_REQUEST);

        exception.getFieldErrors().forEach(er -> apiErrors.addFieldError(er.getField()));

        return ResponseEntity.badRequest().body(apiErrors);
    }
}
