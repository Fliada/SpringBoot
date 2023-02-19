package com.example.demo.model;

import java.util.Date;

public class Post {
    private String  text;
    private Integer likes;
    private Date    creationDate;
    private Long    id;

    public Date getCreationDate() { return (Date)creationDate.clone(); }

    public String getText() {
        return text.toString();
    }

    public int getLikes() {
        return likes.intValue();
    }
    public long getId() { return id.longValue(); }
    public void setLikes(Integer likes) { this.likes = likes; }

    public Post(long id, String text, int likes) {
        this.text =         text;
        this.likes =        likes;
        this.id =           id;
        creationDate = new Date();
    }

    public Post(long id, String text, Date creationDate) {
        this.text =         text;
        this.creationDate = creationDate;
        this.id =           id;
        likes =             0;
    }
}
