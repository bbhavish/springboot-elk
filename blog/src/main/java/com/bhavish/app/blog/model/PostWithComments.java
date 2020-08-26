package com.bhavish.app.blog.model;

import io.swagger.annotations.ApiModel;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ApiModel(value = "Posts with Comments", parent = Post.class)
public class PostWithComments extends Post{

  public List<Comments> commentsList = new ArrayList<>();
}
