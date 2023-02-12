package com.example.demo.service;

import com.example.demo.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {
    public List<Post> listAllPosts()
    {
        return Arrays.asList(
                new Post("afwa", 11),
                new Post("awdafw", 122),
                new Post("afawfafw", 2424)
        );
    }
}
