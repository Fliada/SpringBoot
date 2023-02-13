package com.example.demo.model;

public class Post {
    private String text;
    private Integer likes;

    public String getText() {
        return text.toString();
    }

    public int getLikes() {
        return likes.intValue();
    }

    public Post(String text, int likes) {
        this.text = text;
        this.likes = likes;
    }
}
