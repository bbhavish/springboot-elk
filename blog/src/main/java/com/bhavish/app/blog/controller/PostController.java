package com.bhavish.app.blog.controller;

import com.bhavish.app.blog.model.Post;
import com.bhavish.app.blog.model.PostWithComments;
import com.bhavish.app.blog.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

  @Autowired
  PostService postService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Post>> getPosts() {
    return ResponseEntity.ok(postService.getAllPosts());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PostWithComments> getPost(@PathVariable Long id) {
    return ResponseEntity.ok(postService.getPost(id));
  }

  @PostMapping(path = "/save")
  public ResponseEntity<PostWithComments> savePost(@RequestBody PostWithComments postWithComments) {
    return new ResponseEntity(postService.savePost(postWithComments), HttpStatus.CREATED);
  }
}
