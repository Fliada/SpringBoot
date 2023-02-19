package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import  com.example.demo.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Iterable<Post> listAllPosts () {
        return postRepository.findAll();
    }
    public void create (String text) {
        Post post = new Post(null, text, new Date());
        postRepository.save(post);
    }
}
