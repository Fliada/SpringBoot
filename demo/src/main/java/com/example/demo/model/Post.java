package com.example.demo.model;

import java.util.Date;

public class Post {
    private String text;
    private Integer likes;
    private Date creationDate;

    public Date getCreationDate() { return (Date)creationDate.clone(); }

    public String getText() {
        return text.toString();
    }

    public int getLikes() {
        return likes.intValue();
    }

    public Post(String text, int likes) {
        this.text =         text;
        this.likes =        likes;
        creationDate = new Date();
    }

    public Post(String text, Date creationDate) {
        this.text =         text;
        this.creationDate = creationDate;
        likes =             0;
    }
}
