package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PostService {
    List<Post> posts;

    public PostService() {
        posts = Arrays.asList (
                new Post("afwa",    11),
                new Post("awdafw",  122),
                new Post("afawfafw",2424)
        );
    }

    public List<Post> listAllPosts() {
        return new ArrayList<>(posts);
    }

    public void create(String text) {
        posts.add(new Post(text, new Date()));
    }
}
