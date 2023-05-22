package com.example.demo;

import com.example.demo.controller.*;
import com.example.demo.model.Post;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.*;
import java.util.Date;

/*
 * This is a test class.
 * We need to write 2 integration tests in a class, checking the interaction of controllers (LikesController, PostsCreateController, PostsViewController), service (LikesService, PostService) and database (PostRepository)
 * 1. Check the interaction of the LikesController controller, the LikesService service and the PostRepository repository
 * 2. Check the interaction of the PostsCreateController controller, the PostService service and the PostRepository repository
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/create-post-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(value = {"/create-post-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class DemoApplicationTests {

	//Inject the LikesController service into the test class using the @Autowired annotation
	@Autowired
	private LikesController likesController;
	//Inject the PostsCreateController service into the test class using the @Autowired annotation
	@Autowired
	private PostsCreateController postsCreateController;
	//Inject the LikesService service into the test class using the @Autowired annotation
	@Autowired
	private LikesService likesService;
	//Inject the PostService service into the test class using the @Autowired annotation
	@Autowired
	private PostService postService;
	//Inject the PostRepository repository into the test class using the @Autowired annotation
	@Autowired
	private PostRepository postRepository;

	//Make a check that when you add a liking to a page using main.js, the number of likes on the post changes.
	@Test
	public void testLikesController() {
		//Create a new post
		Post post = new Post(null, "test", new Date());
		//Save the post to the database
		postRepository.save(post);
		//Get the number of likes on the post
		long likes = post.getLikes();
		//Add a like to the post
		likesService.like(post.getId());
		//Get the Post with the specified id from the database
		Post post1 = postRepository.findById(post.getId()).get();
		//Check that the number of likes on the post has changed
		Assertions.assertThat(post1.getLikes()).isEqualTo(likes + 1);
	}

	// Check the interaction of the PostsCreateController, the PostService and the PostRepository
	@Test
	public void testPostsCreateController() {
		//Get the number of posts in the database
		long count = postRepository.count();
		//Create a new post
		Post post = new Post(null, "test", new Date());
		//Save the post to the database
		postRepository.save(post);
		//Create a new post
		postService.create("test");
		//Check that the number of posts in the database has changed
		Assertions.assertThat(postRepository.count()).isEqualTo(count + 2);
	}

	//Check the interaction of the controller of likes with repository and service
	@Test
	public void testController() {
		//Create a new post
		Post post = new Post(null, "test", new Date());
		//Save the post to the database
		postRepository.save(post);
		//Get the number of likes on the post
		long likes = post.getLikes();
		//Add a like to the post
		likesController.like(post.getId());
		//Get the Post with the specified id from the database
		Post post1 = postRepository.findById(post.getId()).get();
		//Check that the number of likes on the post has changed
		Assertions.assertThat(post1.getLikes()).isEqualTo(likes + 1);
		//Get the number of posts in the database
		long count = postRepository.count();
		//Create a new post
		postService.create("test");
		//Check that the number of posts in the database has changed
		Assertions.assertThat(postRepository.count()).isEqualTo(count + 1);
	}

	//Check that post (0, 'First post', '2020-01-01', 0) is in the database
	@Test
	public void testPostRepository() {
		//Get the Post with the specified id from the database
		Post post = postRepository.findById(0L).get();
		//Check that the post is in the database
		Assertions.assertThat(post).isNotNull();
		Assertions.assertThat(post.getId()).isEqualTo(0L);
		Assertions.assertThat(post.getText()).isEqualTo("First post");
		Assertions.assertThat(post.getCreationDate().toString()).isEqualTo("2020-01-01 00:00:00.0");
		Assertions.assertThat(post.getLikes()).isEqualTo(0L);
	}
}