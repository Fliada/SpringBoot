package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LikesServiceTest {
    //Inject the LikesService service into the test class using the @Autowired annotation
    @Autowired
    private LikesService likesService;
    //Subject-plug
    @MockBean
    private PostRepository postRepository;

    //Write a unit-test for the service, using mock-object PostRepository and classes Assert and Mockito
    @Test
    void like() {
        //Need to check that MockBean execute two times
        Long id = 0L;
        //Create a new post
        Post post = new Post(id, "test", new Date());
        Integer likes = post.getLikes();

        Assert.assertTrue(post.getId() != null);

        Mockito.doReturn(Optional.of(post))
                .when(postRepository)
                .findById(id);

        Long new_likes = likesService.like(post.getId());
        //Check that the number of likes on the post has changed
        Assert.assertTrue(new_likes == likes + 1);
    }

    //Test for the service, which check that MockBean execute two times
    @Test
    void like2() {
        //Need to check that MockBean execute two times
        Long id = 0L;
        //Create a new post
        Post post = new Post(id, "test", new Date());
        Integer likes = post.getLikes();

        Assert.assertTrue(post.getId() != null);

        Mockito.doReturn(Optional.of(post))
                .when(postRepository)
                .findById(id);

        likesService.like(post.getId());

        Mockito.verify(postRepository, Mockito.times(1)).findById(post.getId());
        Mockito.verify(postRepository, Mockito.times(1)).save(post);
    }
}