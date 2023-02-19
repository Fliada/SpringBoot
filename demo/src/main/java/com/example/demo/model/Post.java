package com.example.demo.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

    @Entity
    public class Post {
        private String text;
        private Integer likes;
        private Date creationDate;
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        public Date getCreationDate() {
            return creationDate;
        }

        public String getText() {
            return text;
        }

        public Integer getLikes() {
            return likes;
        }

        public Long getId() {
            return id;
        }

        public void setLikes(Integer likes) {
            this.likes = likes;
        }

        public Post() { }

        public Post(Long id, String text, Date creationDate) {
            this.id = id;
            this.text = text;
            this.creationDate = creationDate;
            this.likes = 0;
        }
    }