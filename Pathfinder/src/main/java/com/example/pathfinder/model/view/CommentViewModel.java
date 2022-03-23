package com.example.pathfinder.model.view;


import java.time.LocalDateTime;

public class CommentViewModel {

    private Long id;

    private boolean approved;

    private LocalDateTime created;

    private String textContent;

    private String authorName;


    public CommentViewModel() {
    }


    public Long getId() {
        return id;
    }

    public CommentViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public boolean isApproved() {
        return approved;
    }

    public CommentViewModel setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentViewModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public String getAuthorName() {
        return authorName;
    }

    public CommentViewModel setAuthorName(String authorName) {
        this.authorName = authorName;
        return this;
    }
}
