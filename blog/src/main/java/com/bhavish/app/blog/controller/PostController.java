package com.bhavish.app.blog.controller;

import com.bhavish.app.blog.model.Post;
import com.bhavish.app.blog.model.PostWithComments;
import com.bhavish.app.blog.service.PostService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PostController {

  @Autowired
  PostService postService;

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "traceId", value = "Trace Id", paramType = "header", required = true, dataTypeClass = UUID.class, example = "5da33ac0-6c82-44ea-b0a1-e05e7659d70a")})
  public ResponseEntity<List<Post>> getPosts() {
    log.info("PostController :: Inside get Post");
    return ResponseEntity.ok(postService.getAllPosts());
  }

  @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiImplicitParams({
      @ApiImplicitParam(name = "traceId", value = "Trace Id", paramType = "header", required = true, dataTypeClass = UUID.class, example = "5da33ac0-6c82-44ea-b0a1-e05e7659d70a")})
  public ResponseEntity<PostWithComments> getPost(@PathVariable Long id) {
    log.info("PostController :: Inside get Post with id : {}",id);
    return ResponseEntity.ok(postService.getPost(id));
  }

  @PostMapping(path = "/save")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "traceId", value = "Trace Id", paramType = "header", required = true, dataTypeClass = UUID.class, example = "5da33ac0-6c82-44ea-b0a1-e05e7659d70a")})
  public ResponseEntity<PostWithComments> savePost(@RequestBody PostWithComments postWithComments) {
    log.info("PostController :: Inside savePost method : {}",postWithComments);
    return new ResponseEntity(postService.savePost(postWithComments), HttpStatus.CREATED);
  }
}
