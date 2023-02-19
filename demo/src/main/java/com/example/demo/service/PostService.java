package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {
    ArrayList<Post> posts = new ArrayList<>();
    private long newId = 0;

    public PostService() {
        Collections.addAll(posts,
                new Post(newId++, "afwa",    11),
                new Post(newId++, "awdafw",  122),
                new Post(newId++, "afawfafw",2424)
        );
    }

    public List<Post> listAllPosts() {
        return new ArrayList<>(posts);
    }

    public void create(String text) {
        posts.add(new Post(newId++, text, new Date()));
    }
}
