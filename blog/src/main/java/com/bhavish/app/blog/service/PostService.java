package com.bhavish.app.blog.service;

import com.bhavish.app.blog.model.Comments;
import com.bhavish.app.blog.model.Post;
import com.bhavish.app.blog.model.PostWithComments;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PostService {

  static HashMap<Long, PostWithComments> allPosts = new HashMap();

  public List<Post> getAllPosts() {
    Collection<PostWithComments> values = allPosts.values();
    log.info("Fetching all posts : {}",values);
    List<Post> postsList =
        values.stream()
            .map(
                postWithComments -> {
                  Post post = Post.builder().build();
                  BeanUtils.copyProperties(postWithComments, post);
                  return post;
                })
            .collect(Collectors.toList());
    return postsList;
  }

  public PostWithComments getPost(Long id) {
    log.info("Fetching Post based on id : {}",id);
    return allPosts.get(id);
  }

  public PostWithComments savePost(PostWithComments postWithComments) {
    allPosts.put(postWithComments.getId(), postWithComments);
    log.info("Post saved : {}",allPosts);
    return postWithComments;
  }

  @PostConstruct
  void loadData() {
    Post post = Post.builder().id(1l).title("PostTitle-1").content("PostContent-1").publishDateTime(
        OffsetDateTime.now()).build();
    List<Comments> commentList = new ArrayList<>();
    commentList.add(Comments.builder().id(1l).content("Comment-1").build());
    commentList.add(Comments.builder().id(2l).content("Comment-2").build());
    PostWithComments postWithComments = new PostWithComments();
    BeanUtils.copyProperties(post, postWithComments);
    postWithComments.setCommentsList(commentList);

    allPosts.put(post.getId(),postWithComments);

    post = Post.builder().id(2l).title("PostTitle-2").content("PostContent-2").publishDateTime(
        OffsetDateTime.now()).build();
    postWithComments = new PostWithComments();
    BeanUtils.copyProperties(post, postWithComments);
    postWithComments.setCommentsList(commentList);

    allPosts.put(post.getId(),postWithComments);
    log.info("all post after initial load : {}",allPosts);
  }
}
